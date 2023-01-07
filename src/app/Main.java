package app;

import java.util.Calendar;
import javax.swing.UIManager;

import views.LoginFrame;

public class Main {
    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            //Cac Anh/Chi
           // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // Hieu

        } catch (Exception e) {
        }
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
      }
}

