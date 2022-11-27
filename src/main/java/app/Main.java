package app;

import dbservice.DatabaseConnector;
import dbservice.DatabaseConstant;
import views.LoginFrame;

public class Main {

	public static void main(String[] args) {
		DatabaseConnector.setConnect(DatabaseConstant.getUrl("household-registrations"), DatabaseConstant.userName, DatabaseConstant.password);
		LoginFrame init = new LoginFrame();
		init.setVisible(true);
	}

}
