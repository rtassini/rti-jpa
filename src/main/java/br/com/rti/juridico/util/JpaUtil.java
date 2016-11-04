package br.com.rti.juridico.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("rti-jpa-mysql");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
