package models;

public class HouseholdRegistrationModel {

	private String household_file_no;
	private String householder_name;
	private int house_no;
	private String street_hamlet;
	private String ward_commune_town;
	private String district_township;
	public String getHousehold_file_no() {
		return household_file_no;
	}
	public void setHousehold_file_no(String household_file_no) {
		this.household_file_no = household_file_no;
	}
	public String getHouseholder_name() {
		return householder_name;
	}
	public void setHouseholder_name(String householder_name) {
		this.householder_name = householder_name;
	}
	public int getHouse_no() {
		return house_no;
	}
	public void setHouse_no(int house_no) {
		this.house_no = house_no;
	}
	public String getStreet_hamlet() {
		return street_hamlet;
	}
	public void setStreet_hamlet(String street_hamlet) {
		this.street_hamlet = street_hamlet;
	}
	public String getWard_commune_town() {
		return ward_commune_town;
	}
	public void setWard_commune_town(String ward_commune_town) {
		this.ward_commune_town = ward_commune_town;
	}
	public String getDistrict_township() {
		return district_township;
	}
	public void setDistrict_township(String district_township) {
		this.district_township = district_township;
	}
	
	
}
