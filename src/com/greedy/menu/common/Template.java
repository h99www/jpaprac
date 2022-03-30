package com.greedy.menu.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Template {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {

        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
        }

        return entityManagerFactory.createEntityManager();
    }

    public static void close(EntityManager entityManager) {
        if(entityManager != null ){
            entityManager.close();
        }
    }


}
