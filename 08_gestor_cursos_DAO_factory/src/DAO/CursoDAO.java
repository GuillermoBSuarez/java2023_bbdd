package DAO;

import java.util.List;

import model.Curso;

public interface CursoDAO {

	boolean existeCurso(int idCurso);

	boolean guardarCurso(Curso curso);

	List<Curso> cursos();

}