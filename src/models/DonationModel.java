package models;

public class DonationModel {

	private int ID;
	private String ten_khoan_thu;
	private int so_tien;
	private int idNguoiTao;

	public DonationModel() {
	}

	public DonationModel(int iD, String ten_khoan_thu, int so_tien, int idNguoiTao) {
		super();
		ID = iD;
		this.ten_khoan_thu = ten_khoan_thu;
		this.so_tien = so_tien;
		this.idNguoiTao = idNguoiTao;
	}

	public int getID() {
		return ID;
	}

	public String getTen_khoan_thu() {
		return ten_khoan_thu;
	}

	public int getSo_tien() {
		return so_tien;
	}

	public int getIdNguoiTao() {
		return idNguoiTao;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setTen_khoan_thu(String ten_khoan_thu) {
		this.ten_khoan_thu = ten_khoan_thu;
	}

	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}

	public void setIdNguoiTao(int idNguoiTao) {
		this.idNguoiTao = idNguoiTao;
	}

}
