/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.EntityManagerUtil;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Khayal Baylarov
 */
public class UserDaoImpl extends EntityManagerUtil implements UserDaoInter {

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityId != null && !(nationalityId == 0)) {
            jpql += " and u.nationality.id=:nid";
        }

        Query q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityId != null && !(nationalityId == 0)) {
            q.setParameter("nid", nationalityId);
        }
        return q.getResultList();
    }


    @Override
    public User findByEmailAndPassword(String email, String password) {
        User u = findByEmail(email);
        boolean isVerify = getVerify(password, u.getPassword());
        if (isVerify) {
            return u;
        } else {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean removeUser(int i) {
        EntityManager em = em();
        User u = em.find(User.class, i);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public boolean addUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        try {
            em.persist(u);
        } catch (Exception ex) {
            em.getTransaction().commit();
            emClose(em);
            return false;
        }
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public User getById(int userId) {
        EntityManager em = em();
        User u = em.find(User.class, userId);
        emClose(em);
        return u;
    }

    private boolean getVerify(String password, String hash) {
    //Method writed on AOP
        return false;
    }

}
