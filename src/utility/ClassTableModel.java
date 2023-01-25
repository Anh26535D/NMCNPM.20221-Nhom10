package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import bean.HoKhauBean;
import models.FeesModel;
import models.GiaDinhModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.TieuSuModel;
import services.HoKhauService;

public class ClassTableModel {

	public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem, String[] listColumn) {
		final int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 5 ? Boolean.class : String.class;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		obj = new Object[columns];
		listItem.forEach((NhanKhauModel item) -> {
			obj[0] = item.getID();
			obj[1] = item.getHoTen();
			obj[2] = item.getNamSinh();
			obj[3] = item.getGioiTinh();
			obj[4] = item.getDiaChiHienNay();
			dtm.addRow(obj);
		});
		return dtm;
	}

	public DefaultTableModel setTableTieuSu(List<TieuSuModel> tieuSu, String[] listColumn) {
		final int column = listColumn.length;

		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 5 ? Boolean.class : String.class;
			}
		};

		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		obj = new Object[column];

		tieuSu.forEach((TieuSuModel item) -> {
			obj[0] = item.getTuNgay().toString();
			obj[1] = item.getDenNgay().toString();
			obj[2] = item.getDiaChi();
			obj[3] = item.getNgheNghiep();
			obj[4] = item.getNoiLamViec();
			dtm.addRow(obj);
		});

		dtm.addRow(new Object[] { "", "", "", "", "" });
		return dtm;
	}

	public DefaultTableModel setTableGiaDinh(List<GiaDinhModel> giaDinh, String[] listColumn) {
		final int column = listColumn.length;

		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 6 ? Boolean.class : String.class;
			}
		};

		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		obj = new Object[column];

		giaDinh.forEach((GiaDinhModel item) -> {
			obj[0] = item.getHoTen();
			obj[1] = item.getNamSinh().toString();
			obj[2] = item.getGioiTinh();
			obj[3] = item.getQuanHeVoiNhanKhau();
			obj[4] = item.getNgheNghiep();
			obj[5] = item.getDiaChiHienTai();
			dtm.addRow(obj);
		});

		dtm.addRow(new Object[] { "", "", "", "", "", "" });
		return dtm;
	}

	public DefaultTableModel setTableHoKhau(List<HoKhauBean> listItem, String[] listColumn) {
		final int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column); // To change body of generated methods, choose Tools |
															// Templates.
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 5 ? Boolean.class : String.class;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj;
		obj = new Object[columns];
		listItem.forEach((HoKhauBean item) -> {
			obj[0] = item.getHoKhauModel().getID();
			obj[1] = item.getHoKhauModel().getMaHoKhau();
			obj[2] = item.getChuHo().getHoTen();
			obj[3] = item.getHoKhauModel().getDiaChi();
			obj[4] = item.getHoKhauModel().getNgayLap();
			dtm.addRow(obj);
		});
		return dtm;
	}

	public DefaultTableModel setTableFees(List<FeesModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column);
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((FeesModel item) -> {
            obj[0] = item.getID();
            obj[1] = item.getTen_khoan_thu();
            obj[2] = item.getSo_tien();
            obj[3] = item.getDot_thu();
            dtm.addRow(obj);
        });
        return dtm;
    }

    public DefaultTableModel setHouseholdTable(List<HoKhauBean> households, List<Integer> paids, List<Integer> needs, List<Boolean> paidStates, String[] columns) {
        int len_cols = columns.length;
        int len_rows = households.size();
        DefaultTableModel dtm = new DefaultTableModel()  {
            private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column);
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(columns);
        Object[] obj = new Object[len_cols];
        for(int i=0; i<len_rows; ++i) {
            obj[0] = households.get(i).getHoKhauModel().getMaHoKhau();
            obj[1] = households.get(i).getChuHo().getHoTen();
            obj[2] = households.get(i).getHoKhauModel().getDiaChi();
            obj[3] = paids.get(i);
            obj[4] = needs.get(i);
            if (paidStates.get(i).equals(Boolean.TRUE)) {
            	obj[5] = "Đã nộp đủ";
            }else {
            	obj[5] = "-";
            }
            
            dtm.addRow(obj);         		
        }
        return dtm;
    }
	
}
