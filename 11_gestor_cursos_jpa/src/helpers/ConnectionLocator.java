package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLocator {
	static String cadena = "jdbc:mysql://localhost:3306/formacionfechas";
	static String user = "root", pwd = "root";
		
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadena, user, pwd);
	}
}