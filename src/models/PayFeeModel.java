package models;

import java.sql.Date;

public class PayFeeModel {

	private int idNhanKhau;
	private int idPhiThu;
	private Date ngay_nop;
	private int so_tien;
	
	public PayFeeModel() {
		
	}
	
	public PayFeeModel(int idNhanKhau, int idPhiThu, Date ngay_nop, int so_tien) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idPhiThu = idPhiThu;
		this.ngay_nop = ngay_nop;
		this.so_tien = so_tien;
	}

	public int getIdNhanKhau() {
		return idNhanKhau;
	}

	public int getIdPhiThu() {
		return idPhiThu;
	}

	public Date getNgay_nop() {
		return ngay_nop;
	}

	public int getSo_tien() {
		return so_tien;
	}

	public void setIdNhanKhau(int idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public void setIdPhiThu(int idPhiThu) {
		this.idPhiThu = idPhiThu;
	}

	public void setNgay_nop(Date ngay_nop) {
		this.ngay_nop = ngay_nop;
	}

	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}
	
	
}
