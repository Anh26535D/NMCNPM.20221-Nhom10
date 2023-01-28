package bean;

import java.util.ArrayList;
import java.util.List;

import models.DonationModel;

public class PhiUngHoBean {

    private DonationModel donationModel;
    private List<DonationModel> donationModels;
    
    public PhiUngHoBean() {
        this.donationModel = new DonationModel();
        this.donationModels = new ArrayList<DonationModel>();
	}
    
	public PhiUngHoBean(DonationModel donationModel, List<DonationModel> donationModels) {
		super();
		this.donationModel = donationModel;
		this.donationModels = donationModels;
	}
    
    public DonationModel getDonationModel() {
        return donationModel;
    }


}
