package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import service.LoginService;
import views.HouseholdRegistrationFrame;
import views.LoginFrame;


public class AccountsController implements Action, KeyListener{
	
	private LoginFrame userLogin;
	private LoginService loginService;
	
	public  AccountsController(LoginFrame userLogin) {
		this.userLogin = userLogin;
		this.loginService = new LoginService();
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
        String userName = this.userLogin.getTxtFieldUserName().getText();
        String password = new String(this.userLogin.getPasswordField().getPassword());	
        if (command.equals("Login")) {
	        if(userName.isEmpty() || password.isEmpty()) {
	        	this.userLogin.getLblLoginWarning().setText("*Username and password can not be empty");
	        	this.userLogin.getLblLoginWarning().setForeground(Color.RED);	
	        	this.userLogin.getLblLoginWarning().setVisible(true);	
	        }else {
	        	this.userLogin.getLblLoginWarning().setVisible(false);	
	        	this.loginCommand(userName, password);
	        }
        }
	}
	
	public void loginCommand(String userName, String password) {
        if (this.loginService.isExistAccount(userName, password)) {
//            GreetingFrame greeting = new GreetingFrame(userName);
//            greeting.setTitle("Hello!");
//            greeting.setVisible(true); 
        	HouseholdRegistrationFrame householdFrame = new HouseholdRegistrationFrame();
        	householdFrame.setVisible(true);
            this.userLogin.dispose();;
        }else {
        	JOptionPane.showMessageDialog(this.userLogin.getBtnLoginButton(), "Login failed");
        }
	}

	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	        String userName = this.userLogin.getTxtFieldUserName().getText();
	        String password = new String(this.userLogin.getPasswordField().getPassword());	
	        if(userName.isEmpty() || password.isEmpty()) {
	        	this.userLogin.getLblLoginWarning().setText("*Username and password can not be empty");
	        	this.userLogin.getLblLoginWarning().setForeground(Color.RED);	
	        	this.userLogin.getLblLoginWarning().setVisible(true);	
	        }
	        else{
	        	this.userLogin.getLblLoginWarning().setVisible(false);
	        	this.loginCommand(userName, password);
	        }
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
