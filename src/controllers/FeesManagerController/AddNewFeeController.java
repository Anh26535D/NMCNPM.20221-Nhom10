package controllers.FeesManagerController;

import java.sql.SQLException;

import beans.PhiBatBuocBean;
import models.FeesModel;
import services.FeesService;

public class AddNewFeeController {
	
	private FeesService feesService;
	
	public AddNewFeeController() {
		this.feesService = new FeesService();
	}

	public boolean newFee(PhiBatBuocBean phiBatBuocBean) throws SQLException, ClassNotFoundException{
		return feesService.newFee(phiBatBuocBean);
	}

	public  boolean checkDuplicate(FeesModel value){
		return  feesService.checkDuplicate(value);
	}
}
