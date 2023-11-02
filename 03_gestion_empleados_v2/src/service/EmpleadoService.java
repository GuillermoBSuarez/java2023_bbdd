package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class EmpleadoService {
	
	public boolean grabarEmpleado(Empleado e) {
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "insert into empleados (nombre, email, departamento, salario) "
			/*
			CON STATEMENT
					+ "values ('" + e.getNombre() + "', '" + e.getEmail() + "', '" + e.getDepartamento() + "', " + e.getSalario() + ")";
			Statement st = con.createStatement();
			st.execute(sql);
			*/

//			CON PREPAREDSTATEMENT		
					+ "values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getDepartamento());
			ps.setDouble(4, e.getSalario());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public boolean borrarEmpleado(String email) {
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "delete from empleados where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public boolean actualizarSalario(int id, double salario) {
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "update empleados set salario = ? where idEmpleado = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, salario);
			ps.setInt(2, id);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public List<Empleado> buscarEmpleadosPorDepartamento (String departamento){
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";
		
		List<Empleado> empleados = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from empleados where departamento = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, departamento);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				empleados.add( new Empleado( rs.getInt("idEmpleado"),
											 rs.getString("nombre"),
											 rs.getString("email"),
											 rs.getString("departamento"),
											 rs.getDouble("salario") ) );
			}
			return empleados;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return List.of();
		}
	}
}