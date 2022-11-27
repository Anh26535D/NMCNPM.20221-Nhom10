package dbservice;

public class DatabaseConstant {
	
	static public String serverName = "DESKTOP-04NMIDF\\\\SQLEXPRESS";
	static public String userName = "sa";
	static public String password = "123456";
	
	public static String getUrl(String dbName) {
		String url = "jdbc:sqlserver://" + DatabaseConstant.serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
		return url;
	}
}
                                                    