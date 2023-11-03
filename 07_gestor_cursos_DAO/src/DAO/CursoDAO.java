package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import model.Curso;

public class CursoDAO {
	
	String cadena = "jdbc:mysql://localhost:3306/formacion";
	String user = "root", pwd = "root";
	
	public boolean existeCurso(int idCurso) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from cursos where idCurso = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCurso);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public boolean guardarCurso(Curso curso) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "insert into cursos (idCurso, curso, duracion, precio) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getCurso());
			ps.setInt(3, curso.getDuracion());
			ps.setDouble(4, curso.getPrecio());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public List<Curso> cursos(){
		List<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from cursos";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
									 rs.getString("curso"),
									 rs.getInt("duracion"),
									 rs.getDouble("precio"),
									 null));					// Lista de alumnos nula
			}
		} catch (SQLException ex) {
			ex.printStackTrace(); 
		}
		return cursos;
	}
}