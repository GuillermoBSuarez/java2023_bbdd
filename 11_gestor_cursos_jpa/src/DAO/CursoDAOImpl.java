package DAO;

import static helpers.EntityManagerLocator.getEntityManager;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Curso;

public class CursoDAOImpl implements CursoDAO {
	
	@Override
	public boolean existeCurso(int idCurso) {
		/*Curso curso = getEntityManager().find(Curso.class, idCurso);
		return alumno;*/
		return getEntityManager().find(Curso.class, idCurso)!=null;
	}
	
	@Override
	public boolean guardarCurso(Curso curso) {
		try {
			/* OJO: ESTO NO FUNCIONA
			 * EntityTransaction et = getEntityManager().getTransaction();
			 * et.begin();
			 * getEntityManager().persist(curso);
			 * Porque estamos creando DOS EntityManager, así que ejerce en uno el begin y en el otro el persist.
			 * Hay que hacerlo creando un EntityManager y llamando a ambos procedimientos desde él. Así: */
			
			EntityManager em = getEntityManager();
			EntityTransaction et = em.getTransaction();
			em.persist(curso);
			et.begin();
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Curso> cursos(){
		// Cómo hacer esto se ve en el ejercicio 10_2
		// No hace falta transaction, sólo es lectura
		return getEntityManager()
				.createQuery("select c from Curso c", Curso.class)
				.getResultList();
	}
	
	@Override
	public List<Curso> cursos(LocalDate fechaInicio, LocalDate fechaFin){
		return getEntityManager()
				.createQuery("select c from Curso c where c.fechaInicio between ?1 and ?2", Curso.class)
				.setParameter(1, fechaInicio)
				.setParameter(2, fechaFin)
				.getResultList();
	} 
}