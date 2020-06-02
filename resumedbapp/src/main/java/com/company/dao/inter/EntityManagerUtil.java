/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xeyal
 */
public abstract class EntityManagerUtil {
    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void emClose(EntityManager em) {
        em.close();
    }

    public void emfClose() {
        emf.close();
    }
}
