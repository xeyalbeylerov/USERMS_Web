/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;
import com.company.dao.inter.EntityManagerUtil;
import com.company.dao.inter.EmployementHistorylDaoInter;
import com.company.entity.EmployementHistory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 *
 * @author xeyal
 */
public class EmployementHistorylDaoImpl extends EntityManagerUtil implements EmployementHistorylDaoInter {

    @Override
    public List<EmployementHistory> getAllEmployementHistoryByUserId(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<EmployementHistory> tquery = em.createQuery("Select e from EmployementHistory e where e.id=:id", EmployementHistory.class);
        tquery.setParameter("id", id);
        em.getTransaction().commit();
        emClose(em);
        return tquery.getResultList();
    }

}
