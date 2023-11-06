package DAO;

import static helpers.ConnectionLocator.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {

	@Override
	public boolean existeAlumo(String dni) {
		try (Connection con = getConnection()) {
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
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		try (Connection con = getConnection()) {
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
	@Override
	public List<Alumno> alumnos(){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = getConnection()) {
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
	@Override
	public List<Alumno> alumnos(int curso){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from alumnos where curso = ?");
			ps.setInt(1, curso);
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
	
	@Override
	public boolean borrarAlumno(String dni) {
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement("delete from alumnos where dni = ?");
			ps.setString(1, dni);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
}