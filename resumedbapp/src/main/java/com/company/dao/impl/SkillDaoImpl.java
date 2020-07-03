/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.EntityManagerUtil;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 * @author Khayal Baylarov
 */
public class SkillDaoImpl extends EntityManagerUtil implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<Skill> tquery = em.createQuery("Select s from Skill s", Skill.class);
        em.getTransaction().commit();
        emClose(em);
        return tquery.getResultList();
    }

    @Override
    public Skill getById(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<Skill> tquery = em.createQuery("Select s from Skill s where s.id=:id", Skill.class);
        tquery.setParameter("id", id);
        List<Skill> list = tquery.getResultList();
        em.getTransaction().commit();
        emClose(em);
        return (list.size() != 0) ? list.get(0) : null;
    }

    @Override
    public boolean updateSkill(Skill u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    public boolean insertSkill(Skill skill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    
    @Override
    public boolean removeSkill(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        Skill skill = em.find(Skill.class, id);
        em.remove(skill);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public List<Skill> getByName(String name) {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<Skill> tquery = em.createQuery("Select s from Skill s where s.name=:name", Skill.class);
        tquery.setParameter("name",name);
        em.getTransaction().commit();
        emClose(em);
        return tquery.getResultList();
    }

}
