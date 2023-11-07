package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	void actualizarDatos();

	List<Curso> listadoCursos();
	
	List<Curso> listadoCursos(LocalDate fechaInicio, LocalDate fechaFin);

	List<Alumno> listadoAlumnos(int idCurso);

	boolean borrarAlumno(String dni);

}