package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class AltaEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em = factory.createEntityManager();
		
		// Alta
		Empleado empleado = new Empleado (0, "hibernate", "hiber@gmail.com", "I+D", 2000);
		/* Se incluye un 0 que iría al idEmpleado, pero como lo hemos definido autoincremental no lo usa
		Pero hay que ponerlo. En las llamadas a métodos siempre hay que poner todos los parámetros que tenga definidos. */
		EntityTransaction tx = em.getTransaction();
		tx.begin();										// Comienza la transacción
		em.persist(empleado);							// Grabar el empleado (persistirlo)
		tx.commit();									// Confirmarlo, reflejarlo en la BD.
	}
}