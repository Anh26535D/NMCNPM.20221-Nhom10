package dbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public static Connection connect = null;

	public static void setConnect(String url, String userName, String password) {
		try {
			DatabaseConnector.connect = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println("Cannot connect to MDBS");
			e.printStackTrace();
		}
	}

	public static void closeConnect() {
		try {
			DatabaseConnector.connect.close();
		} catch (SQLException e) {
			System.out.println("Cannot disconnect to MDBS");
			e.printStackTrace();
		}

	}

}