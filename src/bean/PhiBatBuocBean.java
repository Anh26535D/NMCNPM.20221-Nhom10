package bean;

import java.util.ArrayList;
import java.util.List;

import models.ChungMinhThuModel;
import models.FeesModel;
import models.NhanKhauModel;

public class PhiBatBuocBean {

    private FeesModel feesModel;
    private List<FeesModel> feesModels;
    
    public PhiBatBuocBean() {
        this.feesModel = new FeesModel();
        this.feesModels = new ArrayList<>();
	}
    
	public PhiBatBuocBean(FeesModel feesModel, List<FeesModel> feesModels) {
		super();
		this.feesModel = feesModel;
		this.feesModels = feesModels;
	}
    
    public FeesModel getFeesModel() {
        return feesModel;
    }


}
