package service;

import java.time.LocalDate;
import java.util.List;

import DAO.CursosJsonDAO;
import model.Alumno;
import model.Curso;

public class FormacionServiceImpl implements FormacionService {
	@Override
	public void actualizarDatos() {
		var as = DAOFactory.getAlumnoDAO();
		var cs = DAOFactory.getCursoDAO();
		var jsonDAO = new CursosJsonDAO();
		
		jsonDAO.getCursos()									// Stream<Curso>
			.forEach (c -> {								// Recorremos cursos
				if (!cs.existeCurso(c.getIdCurso())) {		// Si el curso no existe en la BD...
					cs.guardarCurso(c);						
				}
				c.getAlumnos().								// Cogemos la List<Alumnos> que es el último campo de Cursos en el json
					forEach( a -> {							// Recorremos alumnos
						if ( !as.existeAlumno(a.getDni())) {
							a.setCurso (c.getIdCurso());	// Añadimos el FK del curso, que no está en el json
							as.guardarAlumno(a);
						}
					});
			});
	}
	
	@Override
	public List<Curso> listadoCursos(){
		var cs = DAOFactory.getCursoDAO();
		return cs.cursos();				
	}

	@Override
	public List<Curso> listadoCursos(LocalDate fechaInicio, LocalDate fechaFin){
		var cs = DAOFactory.getCursoDAO();
		LocalDate Inicio, Fin;
		if (fechaInicio.isBefore(fechaFin)) {		// Si las fechas se han metido en el orden correcto...
			Inicio = fechaInicio;					// ... las asignamos tal cual;
			Fin = fechaFin;
		} else {									// y si no...
			Inicio = fechaFin;						// ... les damos la vuelta.
			Fin = fechaInicio;
		}
		return cs.cursos(Inicio, Fin);				
	}
	
	@Override
	public List<Alumno> listadoAlumnos(int idCurso){		// idCurso = 0  => todos los alumnos
		var as = DAOFactory.getAlumnoDAO();
		return idCurso == 0 ? as.alumnos() : as.alumnos(idCurso);   
	}
	
	@Override
	public boolean borrarAlumno(String dni) {
		var as = DAOFactory.getAlumnoDAO();
		if (!as.existeAlumno(dni)) {					// Si el alumno no existe...
			return false;
		}
		return as.borrarAlumno(dni);
	}
}