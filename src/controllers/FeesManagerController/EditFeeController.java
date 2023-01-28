package controllers.FeesManagerController;

import java.sql.SQLException;

import bean.PhiBatBuocBean;
import services.FeesService;

public class EditFeeController {
	
	private FeesService feesService;
	
	public EditFeeController() {
		this.feesService = new FeesService();
	}

	public boolean editFee(PhiBatBuocBean phiBatBuocBean, int idFee) throws SQLException, ClassNotFoundException{
		return feesService.editFee(phiBatBuocBean, idFee);
	}
}
