package controller;

import service.HouseholdRegistrationService;

public class HouseholdRegistrationController {

	private HouseholdRegistrationService householdRegistrationService;
	
	public HouseholdRegistrationController() {
		this.householdRegistrationService = new HouseholdRegistrationService();
	}
}
