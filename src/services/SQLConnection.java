package services;

import java.sql.*;

public class SQLConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
    	String serverName = "DESKTOP-04NMIDF\\SQLEXPRESS";
    	String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=quan_ly_nhan_khau"  + ";encrypt=true;trustServerCertificate=true;";
        String userName = "sa";
        String password = "123456";
        return DriverManager.getConnection(url, userName, password);
    }
    
    public static Connection getMysqlConnection(String serverName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
        String connectionUrl = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName  + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
        return conn;
    }
}
