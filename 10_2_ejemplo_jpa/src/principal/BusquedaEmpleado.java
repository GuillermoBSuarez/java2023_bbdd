package principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		
		// JPQL Buscar empleados de Ventas. No hace falta transaction
		String dep = "DptoA";
		String jpql = "select e from Empleado e where e.departamento = ?1";
		TypedQuery<Empleado> tq = em.createQuery(jpql, Empleado.class);		// TypedQuery para "recoger" objetos
		tq.setParameter(1, dep);
		List<Empleado> emps = tq.getResultList();
		emps.forEach( e -> System.out.println(e.getNombre()) );
	}
}