package helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerLocator {
	
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("cursosPU").createEntityManager();
	}
}