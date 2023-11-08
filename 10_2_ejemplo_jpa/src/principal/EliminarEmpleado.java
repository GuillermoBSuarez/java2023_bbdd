package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class EliminarEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em = factory.createEntityManager();
		
		// Eliminar el empleado de id 5
		Empleado empleado = em.find(Empleado.class, 5);
		if (empleado != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(empleado);
			tx.commit();
			System.out.println("Kaput");
		} else {
			System.out.println("Nop");
		}
	}
}