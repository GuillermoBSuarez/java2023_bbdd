package service;

import java.util.List;

import DAO.AlumnoDAO;
import DAO.CursoDAO;
import DAO.CursosJsonDAO;
import model.Alumno;
import model.Curso;

public class FormacionService {
	public void actualizarDatos() {
		var as = new AlumnoDAO();
		var cs = new CursoDAO();
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
	
	public List<Curso> listadoCursos(){
		var cursoDAO = new CursoDAO();
		return cursoDAO.cursos();				
	}
	
	public List<Alumno> listadoAlumnos(int idCurso){		// idCurso = 0  => todos los alumnos
		var alumnosDAO = new AlumnoDAO();
		return idCurso == 0 ? alumnosDAO.alumnos() : alumnosDAO.alumnos(idCurso);   
	}
}
