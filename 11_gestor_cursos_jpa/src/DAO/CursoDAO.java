package DAO;

import java.time.LocalDate;
import java.util.List;

import model.Curso;

public interface CursoDAO {

	boolean existeCurso(int idCurso);

	boolean guardarCurso(Curso curso);

	List<Curso> cursos();

	List<Curso> cursos(LocalDate fechainicio, LocalDate fechafin);
}