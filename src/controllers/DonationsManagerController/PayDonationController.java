package controllers.DonationsManagerController;

import java.sql.SQLException;

import models.PayDonationModel;
import services.DonationsService;

public class PayDonationController {
	
	private DonationsService DonationsService;
	
	public PayDonationController() {
		this.DonationsService = new DonationsService();
	}

	public boolean payDonation(PayDonationModel payDonationModel, int idDonation) throws SQLException, ClassNotFoundException{
		return DonationsService.payDonation(payDonationModel, idDonation);
	}
}
