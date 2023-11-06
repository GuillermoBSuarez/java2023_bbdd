package service;

import java.util.List;

import DAO.AlumnoDAO;
import DAO.CursoDAO;
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
						if ( !as.existeAlumo(a.getDni())) {
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
	public List<Alumno> listadoAlumnos(int idCurso){		// idCurso = 0  => todos los alumnos
		var as = DAOFactory.getAlumnoDAO();
		return idCurso == 0 ? as.alumnos() : as.alumnos(idCurso);   
	}
	
	@Override
	public boolean borrarAlumno(String dni) {
		var as = DAOFactory.getAlumnoDAO();
		if (!as.existeAlumo(dni)) {					// Si el alumno no existe...
			return false;
		}
		return as.borrarAlumno(dni);
	}
}