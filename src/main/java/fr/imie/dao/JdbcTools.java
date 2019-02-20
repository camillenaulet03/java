package fr.imie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcTools {

	private static String urldb;
	private static String userdb;
	private static String passworddb;
	private static StringBuffer sb;


	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
		sb= new StringBuffer();
		sb.append(urldb);
		sb.append("?");
		sb.append("user=");
		sb.append(userdb);
		sb.append("&password=");
		sb.append(passworddb);

	}
	
	public static Connection getConnection() throws SQLException{

		Connection connection = DriverManager.getConnection(sb.toString());
		
		return connection;
	}
	
}


