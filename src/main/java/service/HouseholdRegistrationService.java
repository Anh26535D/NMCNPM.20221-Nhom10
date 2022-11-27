package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbservice.DatabaseConnector;
import dbservice.DatabaseConstant;
import models.HouseholdRegistrationModel;

public class HouseholdRegistrationService {

	public List<HouseholdRegistrationModel> all(){
		String sql = "SELECT * FROM household_registration_books";
		
		List<HouseholdRegistrationModel> books = new ArrayList<HouseholdRegistrationModel>();
		
		try {
			PreparedStatement preparedStatement = DatabaseConnector.connect.prepareStatement(sql);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				HouseholdRegistrationModel book = new HouseholdRegistrationModel();
				
				book.setHousehold_file_no(result.getString("household_file_no"));
				book.setHouseholder_name(result.getString("householder_name"));
				book.setHouse_no(result.getInt("house_no"));
				book.setStreet_hamlet(result.getString("street_hamlet"));
				book.setWard_commune_town(result.getString("ward_commune_town"));
				book.setDistrict_township(result.getString("district_township"));
				
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
}
