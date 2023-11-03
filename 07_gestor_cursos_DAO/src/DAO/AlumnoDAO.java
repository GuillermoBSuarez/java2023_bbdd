package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Curso;

public class AlumnoDAO {
	
	String cadena = "jdbc:mysql://localhost:3306/formacion";
	String user = "root", pwd = "root";
	
	public boolean existeAlumo(String dni) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from alumnos where dni = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public boolean guardarAlumno(Alumno alumno) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "insert into alumnos (dni, nombre, edad, nota, curso) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, alumno.getDni());
			ps.setString(2, alumno.getNombre());
			ps.setInt(3, alumno.getEdad());
			ps.setDouble(4, alumno.getNota());
			ps.setInt(5, alumno.getCurso());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	// Listado de TODOS los alumnos
	// ----------------------------
	public List<Alumno> alumnos(){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			PreparedStatement ps = con.prepareStatement("select * from alumnos");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				alumnos.add( new Alumno(rs.getString("dni"),
										rs.getString("nombre"),
										rs.getInt("edad"),
										rs.getDouble("nota"),
										rs.getInt("curso")));
			};
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
		return alumnos;
	}
	
	// SOBRECARGADO: listado de alumnos por curso
	// ------------------------------------------
	public List<Alumno> alumnos(int curso){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			PreparedStatement ps = con.prepareStatement("select * from alumnos where idCurso = ?");
			ps.
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				alumnos.add( new Alumno(rs.getString("dni"),
										rs.getString("nombre"),
										rs.getInt("edad"),
										rs.getDouble("nota"),
										rs.getInt("curso")));
			};
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
		return alumnos;
	}
}