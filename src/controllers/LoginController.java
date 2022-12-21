
package controllers;

import java.sql.SQLException;
import models.UserMoldel;
import services.LoginService;

public class LoginController {
    
    public static UserMoldel currentUser = LoginService.currentUser;
    private LoginService loginService = new LoginService();
    
    public boolean login(String userName, String passwod) throws SQLException, ClassNotFoundException{
    	return loginService.login(userName, passwod);
    }
}
