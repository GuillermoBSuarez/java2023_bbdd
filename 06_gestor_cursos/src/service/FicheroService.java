package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Alumno;
import model.Curso;

public class FicheroService {
	
	public Stream<Curso> getCursos(){
		String ruta = "c:\\temp\\cursos.json";
		Gson gson = new Gson();
		
		try ( FileReader fr = new FileReader(ruta); ){
			Curso[] cursos = gson.fromJson(fr, Curso[].class);
			return Arrays.stream(cursos);
		} catch (IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Curso> cursos() {
		return getCursos().collect(Collectors.toList());
	}
	
	public void actualizarDatos() {
		var as = new AlumnoService();
		var cs = new CursoService();
		
		getCursos()											// Stream<Curso>
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
}