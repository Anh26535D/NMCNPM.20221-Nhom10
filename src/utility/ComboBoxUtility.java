package utility;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.util.Vector;

public class ComboBoxUtility extends JComboBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxUtility(ComboBoxModel aModel) {
		super(aModel);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
	}

	public ComboBoxUtility(Object[] items) {
		super(items);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
	}

	public ComboBoxUtility(Vector items) {
		super(items);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
	}
}
