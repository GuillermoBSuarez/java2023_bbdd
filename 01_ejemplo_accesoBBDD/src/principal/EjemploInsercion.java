package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsercion {

	public static void main(String[] args) {
		// Datos de conexion
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";
		
		/*
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "insert into empleados (nombre, email, departamento, salario) "
					+ "values ('Guillemro', 'guillermobsuarez@gmail.com', 'informatica', 10000)";
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Añadido");
			con.close();
		} catch (SQLException ex) { ex.printStackTrace(); }
		*/
		
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select nombre from empleados";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) { System.out.println( rs.getString("nombre" )); }
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
}
