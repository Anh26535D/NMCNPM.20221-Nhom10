package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbservice.DatabaseConnector;

public class LoginService {

	public boolean isExistAccount(String username, String password) {
		try {
	        String sql = "Select * from accounts where username=? and password=?";
	    	PreparedStatement st = DatabaseConnector.connect.prepareStatement(sql);
	        st.setString(1, username);
	        st.setString(2, password);
	        ResultSet result = st.executeQuery();
	        return result.next();			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
