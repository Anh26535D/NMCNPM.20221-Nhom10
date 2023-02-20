package controllers.NhanKhauManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import models.KhaiTuModel;
import services.SQLConnection;

public class KhaiTuController {
    public int checkCMT(String cmt) {
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT * FROM nhan_khau LEFT JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE soCMT = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cmt);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
    public boolean addNew(KhaiTuModel khaiTuModel) {
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "INSERT INTO khai_tu(ID,soGiayKhaiTu,idNguoiChet,idNguoiKhai, ngayKhai, ngayChet, lyDoChet)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, khaiTuModel.getID());
            preparedStatement.setString(2, khaiTuModel.getSoGiayKhaiTu());
            preparedStatement.setInt(3, khaiTuModel.getIdNguoiKhai());
            preparedStatement.setInt(4, khaiTuModel.getIdNguoiChet());
            Date ngayKhai = new Date(khaiTuModel.getNgayKhai().getTime());
            preparedStatement.setDate(5, ngayKhai);
            Date ngayChet = new Date(khaiTuModel.getNgayChet().getTime());
            preparedStatement.setDate(6, ngayChet);
            preparedStatement.setString(7, khaiTuModel.getLyDoChet());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
