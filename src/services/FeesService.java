package services;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.swing.JOptionPane;

import bean.HoKhauBean;
import bean.PhiBatBuocBean;
import models.*;

public class FeesService {
    private DonationsService donationService = new DonationsService();
    public List<PhiBatBuocBean> allFees() {
        List<PhiBatBuocBean> list = new ArrayList<>();
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT TOP 100 ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc ORDER BY phi_bat_buoc.ID";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PhiBatBuocBean feeBean = new PhiBatBuocBean();
                FeesModel fee = feeBean.getFeesModel();
                fee.setID(rs.getInt("ID"));
                fee.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
                fee.setSo_tien(rs.getInt("so_tien"));
                fee.setDot_thu(rs.getString("dot_thu"));
                list.add(feeBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            exceptionHandle(e.getMessage());
        }
        return list;
    }

    public List<PhiBatBuocBean> searchFeeByID(String keyword) {
        List<PhiBatBuocBean> list = new ArrayList<>();
        if (keyword.trim().isEmpty()) {
            return this.allFees();
        }

        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc " + "WHERE ID LIKE('%" + keyword
                    + "%');";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PhiBatBuocBean feeBean = new PhiBatBuocBean();
                FeesModel fee = feeBean.getFeesModel();
                fee.setID(rs.getInt("ID"));
                fee.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
                fee.setSo_tien(rs.getInt("so_tien"));
                fee.setDot_thu(rs.getString("dot_thu"));
                list.add(feeBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            exceptionHandle(e.getMessage());
        }
        return list;
    }

    public boolean newFee(PhiBatBuocBean phiBatBuocBean) {
        FeesModel fee = phiBatBuocBean.getFeesModel();
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            String query = "INSERT INTO phi_bat_buoc ( ten_khoan_thu, so_tien, dot_thu, ngay_tao, idNguoiTao)" + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fee.getTen_khoan_thu());
            preparedStatement.setInt(2, fee.getSo_tien());
            preparedStatement.setString(3, fee.getDot_thu());
            preparedStatement.setDate(4, new Date(app.Main.calendar.getTime().getTime()));
            preparedStatement.setInt(5, LoginService.currentUser.getID());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return true;
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean editFee(PhiBatBuocBean phiBatBuocBean, int idFee) {
        FeesModel fee = phiBatBuocBean.getFeesModel();
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            String query =
                    "UPDATE phi_bat_buoc "
                            + " SET"
                            + " ten_khoan_thu = ?,"
                            + " so_tien = ?,"
                            + " dot_thu = ?"
                            + " WHERE ID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fee.getTen_khoan_thu());
            preparedStatement.setInt(2, fee.getSo_tien());
            preparedStatement.setString(3, fee.getDot_thu());
            preparedStatement.setInt(4, idFee);

            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return true;
            }
            connection.close();
			preparedStatement.executeUpdate();
			if (rs.next()) {
				return true;
			}
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<PayFeeModel> payByHouseholdId(int householdId) {
		List<PayFeeModel> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = 
					"SELECT ho_khau.maHoKhau, phi_bat_buoc.ten_khoan_thu, phi_bat_buoc.dot_thu, phi_bat_buoc.so_tien, COUNT(*) AS SoThanhVienTrongHo, SUM(nop_phi.so_tien) AS TongTienDaNop FROM ho_khau\r\n"
					+ "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idHoKhau = ho_khau.ID\r\n"
					+ "JOIN nop_phi ON nop_phi.idNhanKhau = thanh_vien_cua_ho.idNhanKhau\r\n"
					+ "JOIN phi_bat_buoc ON phi_bat_buoc.ID = nop_phi.idPhiThu\r\n"
					+ "WHERE ho_khau.ID = ?\r\n"
					+ "GROUP BY ho_khau.maHoKhau, phi_bat_buoc.ten_khoan_thu, phi_bat_buoc.dot_thu, phi_bat_buoc.so_tien;";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, householdId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PayFeeModel model = new PayFeeModel();
				model.setMaHoKhau(rs.getString("maHoKhau"));
				model.setTenKhoanThu(rs.getString("ten_khoan_thu"));
				model.setDot_thu(rs.getString("dot_thu"));
				model.setSo_tien(rs.getInt("so_tien"));
				model.setSoThanhVienCuaHo(rs.getInt("SoThanhVienTrongHo"));
				model.setTongTienDaNop(rs.getInt("TongTienDaNop"));
				model.setTongTienCanNop(rs.getInt("so_tien") * rs.getInt("SoThanhVienTrongHo"));
				list.add(model);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

    public Integer getNeed(HoKhauBean householdBean, FeesModel feesModel) {
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            HoKhauModel household = householdBean.getHoKhauModel();
            String maHoKhau = household.getMaHoKhau();
            int idPhiThu = feesModel.getID();
            String query_get_num_of_people_in_household = "SELECT COUNT(*) AS so_luong_nk_trong_hk FROM nhan_khau"
                    + " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
                    + " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau" + " WHERE ho_khau.maHoKhau = '"
                    + maHoKhau + "';";
            String query_get_basic_fee = "SELECT so_tien FROM phi_bat_buoc"
                    + " WHERE ID = " + idPhiThu + ";";
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query_get_num_of_people_in_household);
                rs.next();
                int num_of_people_in_household = rs.getInt("so_luong_nk_trong_hk");

                rs = st.executeQuery(query_get_basic_fee);
                rs.next();
                int basic_fee = rs.getInt("so_tien");

                connection.close();

                return basic_fee * num_of_people_in_household;

            } catch (SQLException e) {
                exceptionHandle(e.getMessage());
            }
        } catch (ClassNotFoundException e1) {
            exceptionHandle(e1.getMessage());
        } catch (SQLException e1) {
            exceptionHandle(e1.getMessage());
        }
        return -1;
    }

    public boolean checkDuplicate(FeesModel value) {
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT * FROM phi_bat_buoc" + "WHERE ten_khoan_thu = N'" + value.getTen_khoan_thu() + "'" + "LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace();
            return false;
        }
        return true;
    }

    public Integer getPaid(HoKhauBean householdBean, FeesModel feesModel) {
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            HoKhauModel household = householdBean.getHoKhauModel();
            String maHoKhau = household.getMaHoKhau();
            int idPhiThu = feesModel.getID();
            String paid =
                    "SELECT SUM(so_tien) AS tong_tien FROM nop_phi"
                            + " JOIN nhan_khau ON nhan_khau.ID = nop_phi.idNhanKhau"
                            + " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
                            + " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau"
                            + " WHERE ho_khau.maHoKhau = '" + maHoKhau + "' AND nop_phi.idPhiThu = " + idPhiThu + ";";
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(paid);
                rs.next();
                int tong_tien = rs.getInt("tong_tien");
                connection.close();
                return tong_tien;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return -1;
    }

    public Integer getPaidFee(FeesModel feesModel) {
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            int idPhiThu = feesModel.getID();
            String paid =
                    "SELECT SUM(so_tien) AS tong_tien FROM nop_phi"
                            + " WHERE nop_phi.idPhiThu = " + idPhiThu + ";";
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(paid);
                rs.next();
                int tong_tien = rs.getInt("tong_tien");
                connection.close();
                return tong_tien;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return -1;
    }

    public boolean payFee(PayFeeModel payFeeModel, int idFee) {
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            String query = "IF (SELECT COUNT(*) FROM nop_phi WHERE idNhanKhau = ?) > 0\r\n"
            		+ "	UPDATE nop_phi SET so_tien = ?, ngay_nop = ?\r\n"
            		+ "	WHERE idNhanKhau = ?;\r\n"
            		+ "ELSE \r\n"
            		+ "	INSERT INTO nop_phi( idNhanKhau, idPhiThu, ngay_nop, so_tien) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, payFeeModel.getIdNhanKhau());
            preparedStatement.setInt(2, payFeeModel.getSo_tien());
            preparedStatement.setDate(3, new Date(app.Main.calendar.getTime().getTime()));
            preparedStatement.setInt(4, payFeeModel.getIdNhanKhau());
            preparedStatement.setInt(5, payFeeModel.getIdNhanKhau());
            preparedStatement.setInt(6, idFee);
            preparedStatement.setDate(7, new Date(app.Main.calendar.getTime().getTime()));
            preparedStatement.setInt(8, payFeeModel.getSo_tien());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return true;
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public List<HoKhauBean> getListWithFilter(FeesModel fee,String condition)  {
        List<HoKhauBean> list = new ArrayList<>();
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query;
            if (condition.equals(new String("Đã nộp"))) {
                query = "SELECT * FROM ho_khau WHERE ID in (SELECT ho_khau.ID\n" +
                        "FROM nop_phi\n" +
                        "JOIN phi_bat_buoc ON nop_phi.idPhiThu = phi_bat_buoc.ID\n" +
                        "JOIN nhan_khau ON nop_phi.idNhanKhau = nhan_khau.ID\n" +
                        "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID\n" +
                        "JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau\n" +
                        "WHERE MONTH(nop_phi.ngay_nop)=? and YEAR(nop_phi.ngay_nop)=?\n" +
                        "GROUP BY ho_khau.ID,phi_bat_buoc.so_tien\n" +
                        "HAVING phi_bat_buoc.so_tien * (SELECT COUNT(*) FROM thanh_vien_cua_ho as F2 WHERE ho_khau.ID = F2.idHoKhau) <= SUM(nop_phi.so_tien))";
            }else {
                query = "SELECT * FROM ho_khau AS hk1\r\n"
                		+ "WHERE hk1.ID NOT IN ( \r\n"
                		+ "SELECT ho_khau.ID\r\n"
                		+ "FROM nop_phi \r\n"
                		+ "JOIN phi_bat_buoc ON nop_phi.idPhiThu = phi_bat_buoc.ID \r\n"
                		+ "JOIN nhan_khau ON nop_phi.idNhanKhau = nhan_khau.ID \r\n"
                		+ "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID \r\n"
                		+ "JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau \r\n"
                		+ "WHERE MONTH(nop_phi.ngay_nop)=? and YEAR(nop_phi.ngay_nop)=?\r\n"
                		+ "GROUP BY ho_khau.ID, phi_bat_buoc.so_tien \r\n"
                		+ "HAVING phi_bat_buoc.so_tien * (SELECT COUNT(*) FROM thanh_vien_cua_ho as F2 WHERE ho_khau.ID = F2.idHoKhau) <= SUM(nop_phi.so_tien))";
            }
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1,fee.getMonthDotThu());
            preparedStatement.setString(2,fee.getYearDotThu());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                HoKhauBean temp = new HoKhauBean();
                HoKhauModel hoKhauModel = temp.getHoKhauModel();
                hoKhauModel.setID(rs.getInt("ID"));
                hoKhauModel.setIdChuHo(rs.getInt("idCHuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setMaKhuVuc(rs.getString("maKhuVuc"));
                hoKhauModel.setNgayLap(rs.getDate("ngayLap"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                NhanKhauModel chuHo = temp.getChuHo();
                chuHo.setID(rs.getInt("ID"));
                chuHo.setHoTen(rs.getString("hoTen"));
                chuHo.setGioiTinh(rs.getString("gioiTinh"));
                chuHo.setNamSinh(rs.getDate("namSinh"));
                chuHo.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                try {
                    String sql = "SELECT * FROM nhan_khau JOIN thanh_vien_cua_ho ON nhan_khau.ID = thanh_vien_cua_ho.idNhanKhau "
                            + "WHERE thanh_vien_cua_ho.idHoKhau = "
                            + hoKhauModel.getID();
                    PreparedStatement prst = connection.prepareStatement(sql);
                    ResultSet rs_1 = prst.executeQuery();
                    List<NhanKhauModel> listNhanKhau = temp.getListNhanKhauModels();
                    List<ThanhVienCuaHoModel> listThanhVienCuaHo = temp.getListThanhVienCuaHo();
                    while (rs_1.next()) {
                        NhanKhauModel nhanKhauModel = new NhanKhauModel();
                        ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
                        nhanKhauModel.setID(rs_1.getInt("idNhanKhau"));
                        nhanKhauModel.setBietDanh(rs_1.getString("bietDanh"));
                        nhanKhauModel.setHoTen(rs_1.getString("hoTen"));
                        nhanKhauModel.setGioiTinh(rs_1.getString("gioiTinh"));
                        nhanKhauModel.setNamSinh(rs_1.getDate("namSinh"));
                        nhanKhauModel.setNguyenQuan(rs_1.getString("nguyenQuan"));
                        nhanKhauModel.setTonGiao(rs_1.getString("tonGiao"));
                        nhanKhauModel.setDanToc(rs_1.getString("danToc"));
                        nhanKhauModel.setQuocTich(rs_1.getString("quocTich"));
                        nhanKhauModel.setSoHoChieu(rs_1.getString("soHoChieu"));
                        nhanKhauModel.setNoiThuongTru(rs_1.getString("noiThuongTru"));
                        nhanKhauModel.setDiaChiHienNay(rs_1.getString("diaChiHienNay"));

                        thanhVienCuaHoModel.setIdHoKhau(rs_1.getInt("idHoKhau"));
                        thanhVienCuaHoModel.setIdNhanKhau(rs_1.getInt("idNhanKhau"));
                        thanhVienCuaHoModel.setQuanHeVoiChuHo(rs_1.getString("quanHeVoiChuHo"));
                        listNhanKhau.add(nhanKhauModel);
                        listThanhVienCuaHo.add(thanhVienCuaHoModel);
                    }
                } catch (Exception e) {
                    System.out.println("services.HoKhauService.getListHoKhau()");
                    System.out.println(e.getMessage());
                }
                List<DonateModel> donateModel = donationService.donateByHouseholdId(hoKhauModel.getID());
                List<PayFeeModel> payFeeModel = this.payByHouseholdId(hoKhauModel.getID());
                temp.setDonateModels(donateModel);
                temp.setPayFeeModels(payFeeModel);
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        }catch (SQLException error){
            error.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

}
