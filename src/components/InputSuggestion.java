package components;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public abstract class InputSuggestion extends JTextField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPopupMenu popupMenu;
    private JList<String> listComp;
    DefaultListModel<String> listModel;
    private boolean disableTextEvent = false;

    public boolean isDisableTextEvent() {
        return disableTextEvent;
    }

    public void setDisableTextEvent(boolean disableTextEvent) {
        this.disableTextEvent = disableTextEvent;
    }

    /**
     * Constructs a new <code>TextField</code>.  A default model is created,
     * the initial string is <code>null</code>,
     * and the number of columns is set to 0.
     */
    public InputSuggestion(boolean isDisableTextEvent) {
        super();
        this.disableTextEvent = isDisableTextEvent;
        init();
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the
     * specified text. A default model is created and the number of
     * columns is 0.
     *
     * @param text the text to be displayed, or <code>null</code>
     */
    public InputSuggestion(String text) {
        super(text);
        init();
    }

    /**
     * Constructs a new empty <code>TextField</code> with the specified
     * number of columns.
     * A default model is created and the initial string is set to
     * <code>null</code>.
     *
     * @param columns the number of columns to use to calculate
     *                the preferred width; if columns is set to zero, the
     *                preferred width will be whatever naturally results from
     *                the component implementation
     */
    public InputSuggestion(int columns) {
        super(columns);
        init();
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the
     * specified text and columns.  A default model is created.
     *
     * @param text    the text to be displayed, or <code>null</code>
     * @param columns the number of columns to use to calculate
     *                the preferred width; if columns is set to zero, the
     *                preferred width will be whatever naturally results from
     *                the component implementation
     */
    public InputSuggestion(String text, int columns) {
        super(text, columns);
        init();
    }

    /**
     * Constructs a new <code>JTextField</code> that uses the given text
     * storage model and the given number of columns.
     * This is the constructor through which the other constructors feed.
     * If the document is <code>null</code>, a default model is created.
     *
     * @param doc     the text storage to use; if this is <code>null</code>,
     *                a default will be provided by calling the
     *                <code>createDefaultModel</code> method
     * @param text    the initial string to display, or <code>null</code>
     * @param columns the number of columns to use to calculate
     *                the preferred width &gt;= 0; if <code>columns</code>
     *                is set to zero, the preferred width will be whatever
     *                naturally results from the component implementation
     * @throws IllegalArgumentException if <code>columns</code> &lt; 0
     */
    public InputSuggestion(Document doc, String text, int columns) {
        super(doc, text, columns);
        init();
    }

    public void init() {
        initPopup();
        initSuggestionCompListener();
        initInvokerKeyListeners();
    }

    private void initPopup() {
        popupMenu = new JPopupMenu();
        listModel = new DefaultListModel<>();
        listComp = new JList<>(listModel);
        listComp.setBorder(BorderFactory.createEmptyBorder(0, 2, 5, 2));
        listComp.setFocusable(false);
        popupMenu.setFocusable(false);
        popupMenu.add(listComp);
    }

    private void initSuggestionCompListener() {
        final String inputText = this.getText();
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update(e);
            }

            private void update(DocumentEvent e) {
                if (disableTextEvent) {
                    return;
                }
                SwingUtilities.invokeLater(() -> {
                    List<String> suggestions = null;
                    try {
                        suggestions = getSuggestions(e.getDocument().getText(0, e.getDocument().getLength()));
                    } catch (BadLocationException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (suggestions != null && !suggestions.isEmpty()) {
                        showPopup(suggestions);
                    } else {
                        popupMenu.setVisible(false);
                    }
                });
            }
        });
    }//todo init invoker components other than text components


    private void showPopup(List<String> suggestions) {
        listModel.clear();
        suggestions.forEach(listModel::addElement);
        Point p = new Point(0, this.getPreferredSize().height);
        if (p == null) {
            return;
        }
        popupMenu.pack();
        listComp.setSelectedIndex(0);
        popupMenu.show(this, (int) p.getX(), (int) p.getY());
    }

    private void initInvokerKeyListeners() {
        //not using key inputMap cause that would override the original handling
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER) {
                    selectFromList(e);
                } else if (e.getKeyCode() == VK_UP) {
                    moveUp(e);
                } else if (e.getKeyCode() == VK_DOWN) {
                    moveDown(e);
                } else if (e.getKeyCode() == VK_ESCAPE) {
                    popupMenu.setVisible(false);
                }
            }
        });
    }

    private void selectFromList(KeyEvent e) {
        if (popupMenu.isVisible()) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex != -1) {
                popupMenu.setVisible(false);
                String selectedValue = listComp.getSelectedValue();
                disableTextEvent = true;
                System.out.println(selectedValue);
                this.setText(selectedValue);
                disableTextEvent = false;
                e.consume();
            }
        }
    }

    private void moveDown(KeyEvent keyEvent) {
        if (popupMenu.isVisible() && listModel.getSize() > 0) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex < listModel.getSize()) {
                listComp.setSelectedIndex(selectedIndex + 1);
                keyEvent.consume();
            }
        }
    }

    private void moveUp(KeyEvent keyEvent) {
        if (popupMenu.isVisible() && listModel.getSize() > 0) {
            int selectedIndex = listComp.getSelectedIndex();
            if (selectedIndex > 0) {
                listComp.setSelectedIndex(selectedIndex - 1);
                keyEvent.consume();
            }
        }
    }

    public abstract List<String> getSuggestions(String textContent);
}
