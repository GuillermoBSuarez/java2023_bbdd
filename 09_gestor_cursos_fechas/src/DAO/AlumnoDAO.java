package DAO;

import java.util.List;

import model.Alumno;

public interface AlumnoDAO {

	boolean existeAlumo(String dni);

	boolean guardarAlumno(Alumno alumno);

	// Listado de TODOS los alumnos
	// ----------------------------
	List<Alumno> alumnos();

	// SOBRECARGADO: listado de alumnos por curso
	// ------------------------------------------
	List<Alumno> alumnos(int curso);

	boolean borrarAlumno(String dni);

}