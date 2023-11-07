package DAO;

import static helpers.EntityManagerLocator.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {

	@Override
	public boolean existeAlumno(String dni) {
		/*Alumno alumno = getEntityManager().find(Alumno.class, dni);
		return alumno;*/
		return getEntityManager().find(Alumno.class, dni)!=null;
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// No se comprueba antes si existe el alumno porque esto es la capa DAO y eso le toca a la lógica de negocio.
		// Aquí vamos a lo concreto del método: ¿es de grabar? Pues graba.
		try {
			EntityTransaction et = getEntityManager().getTransaction();
			et.begin();
			getEntityManager().persist(alumno);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean guardarAlumnos
	
	// Listado de TODOS los alumnos
	// ----------------------------
	@Override
	public List<Alumno> alumnos(){
		return null;
	}
	
	// SOBRECARGADO: listado de alumnos por curso
	// ------------------------------------------
	@Override
	public List<Alumno> alumnos(int curso){
		return null;
	}
	
	@Override
	public boolean borrarAlumno(String dni) {
	}
}