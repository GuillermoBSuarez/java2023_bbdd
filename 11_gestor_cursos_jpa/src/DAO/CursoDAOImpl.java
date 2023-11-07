package DAO;

import static helpers.ConnectionLocator.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoDAOImpl implements CursoDAO {
	
	@Override
	public boolean existeCurso(int idCurso) {
		
	}
	
	@Override
	public boolean guardarCurso(Curso curso) {
		
	}
	
	@Override
	public List<Curso> cursos(){
		// más adelante
		return null;
	}
	
	@Override
	public List<Curso> cursos(LocalDate fechaInicio, LocalDate fechaFin){
		// más adelante
		return null;
	}
}