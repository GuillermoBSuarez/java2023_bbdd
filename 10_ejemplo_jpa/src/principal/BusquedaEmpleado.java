package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class BusquedaEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em = factory.createEntityManager();
		
		// Busqueda del empleado de id 5, porque el método find busca por PK
		Empleado empleado = em.find(Empleado.class, 5);
		if (empleado != null) {
			System.out.println(empleado.getNombre());
		} else {
			System.out.println("Nop");
		}
	}
}