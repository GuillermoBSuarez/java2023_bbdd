package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Alumno;
import model.Curso;

public class AlumnoService {
	
	String cadena = "jdbc:mysql://localhost:3386/cursos";
	String user = "root", pwd = "root";
	
	public boolean actualizarDatos(List<Curso> cursos) {
		
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sqlCurso = "select * from cursos where IdCurso = ?";
			PreparedStatement psCurso = con.prepareStatement(sqlCurso);
			psCurso.setInt(1, curso.getIdCurso());
			ResultSet rsCurso = psCurso.executeQuery();
			
			for (Curso curso : cursos) {
				if (!(rsCurso.next())) {
					grabarCurso(curso);

					for (Alumno alumno:curso.getAlumnos()) {
						String sqlAlumno = "select * from alumnos where dni = ?";
						PreparedStatement psAlumno = con.prepareStatement(sqlAlumno);
						psAlumno.setString(1, alumno.getDni());
						ResultSet rsAlumno = psAlumno.executeQuery();
						if (!(rsAlumno.next())) {
							grabarAlumno(alumno);
						}			
					}
				}
			}
			
		} catch (SQLException ex) {
				ex.printStackTrace(); 
				return false;
		}		
		return false;
	}
	
	public void grabarCurso(Curso curso) {
		String sql = "insert into cursos values (?,?,?,?)"		
	}
	
	public boolean grabarAlumno(Alumno alumno) {
		return false;		
	}
		
	public void consulta() {
		
	}

}
