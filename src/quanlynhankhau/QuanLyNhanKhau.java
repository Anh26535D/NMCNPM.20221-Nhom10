package quanlynhankhau;

import java.util.Calendar;
import javax.swing.UIManager;
import views.LoginUI;

public class QuanLyNhanKhau {

    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true); 
    }
    
}

//Note: Phan SEARCH trong HoKhauService can` chuyen doi sang sql server (thieu fulltext index)
//Note: Phan SEARCH trong NhanKhauService can` chuyen doi sang sql server (thieu fulltext index)
//Note: Chua check cac chuc nang khac

