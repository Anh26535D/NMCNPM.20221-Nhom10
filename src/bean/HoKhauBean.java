package bean;

import java.util.ArrayList;
import java.util.List;

import models.DonateModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;

public class HoKhauBean {
    private HoKhauModel hoKhauModel;
    private NhanKhauModel chuHo;
    private List<NhanKhauModel> listNhanKhauModels;
    private List<ThanhVienCuaHoModel> listThanhVienCuaHo;
    private List<DonateModel> donateModels;

    public HoKhauBean(HoKhauModel hoKhauModel, NhanKhauModel chuHo, List<NhanKhauModel> listNhanKhauModels, List<ThanhVienCuaHoModel> listThanhVienCuaHo, List<DonateModel> donateModels) {
        this.hoKhauModel = hoKhauModel;
        this.chuHo = chuHo;
        this.listNhanKhauModels = listNhanKhauModels;
        this.listThanhVienCuaHo = listThanhVienCuaHo;
        this.donateModels = donateModels;
    }
    
    public HoKhauBean() {
        this.hoKhauModel = new HoKhauModel();
        this.chuHo = new NhanKhauModel();
        this.listNhanKhauModels = new ArrayList<>();
        this.listThanhVienCuaHo = new ArrayList<>();
        this.donateModels = new ArrayList<>();
    }

    
    public HoKhauModel getHoKhauModel() {
        return hoKhauModel;
    }

    public void setHoKhauModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public NhanKhauModel getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhauModel chuHo) {
        this.chuHo = chuHo;
    }

    public List<NhanKhauModel> getListNhanKhauModels() {
        return listNhanKhauModels;
    }

    public void setListNhanKhauModels(List<NhanKhauModel> listNhanKhauModels) {
        this.listNhanKhauModels = listNhanKhauModels;
    }

    public List<ThanhVienCuaHoModel> getListThanhVienCuaHo() {
        return listThanhVienCuaHo;
    }

    public void setListThanhVienCuaHo(List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.listThanhVienCuaHo = listThanhVienCuaHo;
    }
    
    public void setDonateModels(List<DonateModel> donateModels) {
    	this.donateModels = donateModels;
    }

    @Override
    public String toString() {
//        String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 80%}</style>";
        String res = "<html>\n"
        		+ "  <style>\n"
        		+ "    html {\n"
        		+ "      scroll-behavior: smooth;\n"
        		+ "    }\n"
        		+ "    p {\n"
        		+ "      padding: 5px; \n"
        		+ "      margin-left: 20px\n"
        		+ "    } \n"
        		+ "\n"
        		+ "    table, th, td {\n"
        		+ "      border: 1px solid black; \n"
        		+ "      border-collapse: collapse;\n"
        		+ "    } \n"
        		+ "    table {\n"
        		+ "      width: 100%;\n"
        		+ "    }\n"
        		+ "\n"
        		+ "    div {\n"
        		+ "		 width: 100%;\n"
        		+ "      margin: auto;\n"
        		+ "    }\n"
        		+ "  </style>";
        res +="<div>"
            + "<h3>Thông tin cơ bản"
            + "<p>Mã hộ khẩu: <b>" + hoKhauModel.getMaHoKhau() + "</p>"
            + "<p>Họ tên chủ hộ: <b>" + chuHo.getHoTen() + "</p>"
            + "<p>Địa chỉ: <b>" + hoKhauModel.getDiaChi() + "</p>"
            + "<p>Ngày lập: <b>" + hoKhauModel.getNgayLap().toString() + "</p>"
            + "<h4>Danh sách thành viên<table>"
            + "<tr>"
            + "<th>Họ tên</th>"
            + "<th>Ngày sinh</th>"
            + "<th>Giới tính</th>"
            + "<th>Quan hệ với chủ hộ</th>"
            + "</tr>";
        for (int i = 0; i < listNhanKhauModels.size(); i++) {
            res += "<tr>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getNamSinh().toString()
                    + "</td>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getGioiTinh()
                    + "</td>"
                    + "<td>"
                    + listThanhVienCuaHo.get(i).getQuanHeVoiChuHo()
                    + "</td>"
                    + "</tr>";
        }
        res += "</table>"
        	+ "<h4>Dánh sách ủng hộ</h4>"
        	+ "<table>"
        	+ "<tr>"
        	+ "<th>Họ và tên người nộp</th>"
        	+ "<th>Quan hệ với chủ hộ</th>"
        	+ "<th>Tên khoản thu</th>"
        	+ "<th>Số tiền</th>"
        	+ "<th>Ngày nộp</th>"
        	+ "<th>Ngày tạo</th>"
        	+ "</tr>";
        for (int i = 0; i < donateModels.size(); i++) {
            res += "<tr>"
                    + "<td>"
                    + donateModels.get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + donateModels.get(i).getQuanHeVoiChuHo()
                    + "</td>"
                    + "<td>"
                    + donateModels.get(i).getTen_khoan_thu()
                    + "</td>"
                    + "<td>"
                    + donateModels.get(i).getSo_tien()
                    + "</td>"
                    + "<td>"
                    + donateModels.get(i).getNgay_nop().toString()
                    + "</td>"
                    + "<td>"
                    + donateModels.get(i).getNgay_Tao().toString()
                    + "</td>"
                    + "</tr>";
        }
        res += "</table>";
        
        
        res += "</div></html>";
        return res;
    }

}
