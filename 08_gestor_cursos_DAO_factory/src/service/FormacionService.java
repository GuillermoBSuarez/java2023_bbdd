package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	void actualizarDatos();

	List<Curso> listadoCursos();

	List<Alumno> listadoAlumnos(int idCurso);

	boolean borrarAlumno(String dni);

}