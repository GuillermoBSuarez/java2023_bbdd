package DAO;

import static helpers.EntityManagerLocator.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
			/* OJO: ESTO NO FUNCIONA
			 * EntityTransaction et = getEntityManager().getTransaction();
			 * et.begin();
			 * getEntityManager().persist(curso);
			 * Porque estamos creando DOS EntityManager, así que ejerce en uno el begin y en el otro el persist.
			 * Hay que hacerlo creando un EntityManager y llamando a ambos procedimientos desde él. Así: */
			
			EntityManager em = getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(alumno);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try {
			EntityManager em = getEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			for(Alumno alumno:alumnos) {
				em.persist(alumno);
			}
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	} 
	
	// Listado de TODOS los alumnos
	// ----------------------------
	@Override
	public List<Alumno> alumnos(){
		// Cómo hacer esto se ve en el ejercicio 10_2
		// No hace falta transaction, sólo es lectura
		EntityManager em = getEntityManager();
		TypedQuery<Alumno> tq = em.createQuery(
				"select a from Alumno a",
				Alumno.class
		);
		return tq.getResultList();
	}
	
	// SOBRECARGADO: listado de alumnos por curso
	// ------------------------------------------
	@Override
	public List<Alumno> alumnos(int curso){
		EntityManager em = getEntityManager();
		/*
		TypedQuery<Alumno> tq = em.createQuery(
				"select a from Alumno a where a.curso = ?1",
				Alumno.class
		);
		tq.setParameter(1, curso);
		
		Y ahora... ¡EN FORMATO FUNCIONAL! */
		return em
				.createQuery("select a from Alumno a where a.curso = ?1", Alumno.class)
				.setParameter(1,  curso)
				.getResultList();
	}
	
	@Override
	public boolean borrarAlumno(String dni) {
		// Aquí modificamos la table: hace falta persistence, transaction y query
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em = factory.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		int borrados = em.createQuery("delete Alumno a where a.dni = ?1")
						 .setParameter(1, dni)
						 .executeUpdate();
		et.commit();
		return borrados > 0 ? true:false;
	}
}