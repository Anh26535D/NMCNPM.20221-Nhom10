package controllers.FeesManagerController;

import java.sql.SQLException;

import bean.PhiBatBuocBean;
import services.FeesService;

public class AddNewFeeController {
	
	private FeesService feesService;
	
	public AddNewFeeController() {
		this.feesService = new FeesService();
	}

	public boolean newFee(PhiBatBuocBean phiBatBuocBean) throws SQLException, ClassNotFoundException{
		return feesService.newFee(phiBatBuocBean);
	}
}
