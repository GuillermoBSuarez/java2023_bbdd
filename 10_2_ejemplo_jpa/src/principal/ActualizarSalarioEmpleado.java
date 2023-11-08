package principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Empleado;

public class ActualizarSalarioEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em = factory.createEntityManager();
		
		// JPQL Subir salarios de los empleados del departamento indicado
		double factor = 1.1;
		String departamento = "DptoB";
		String jpql = "update Empleado e set e.salario = e.salario * ?1 where e.departamento = ?2";
		Query q = em.createQuery(jpql);			// Query para OPERAR en la tabla. Y al importar, ojo, el de Persistence.
		q.setParameter(1, factor);
		q.setParameter(2, departamento);
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("Actualizados: " + q.executeUpdate());		// Porque executeUpdate devuelve un int con el número de registros modificados
		et.commit();
		
	}

}
