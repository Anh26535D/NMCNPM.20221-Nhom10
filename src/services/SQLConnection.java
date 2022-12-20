package services;

import java.sql.*;

public class SQLConnection {
	public static String serverName = "127.0.0.1";
	public static String databaseName = "quan_ly_nhan_khau";
	public static String userName = "sa";
	public static String password = "12345678*A";
	

    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
    	String url = "jdbc:sqlserver://" + SQLConnection.serverName + ":1433;DatabaseName=" + SQLConnection.databaseName  + ";encrypt=true;trustServerCertificate=true;";
        return DriverManager.getConnection(url, SQLConnection.userName, SQLConnection.password);
    }
    
    public static Connection getDbConnection(String serverName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
        String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName  + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}