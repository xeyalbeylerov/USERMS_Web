
package com.company.dao.impl;

import com.company.dao.inter.EntityManagerUtil;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
/**
 * @author Khayal Baylarov
 */
public class UserSkillDaoImpl extends EntityManagerUtil implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        EntityManager em = em();

        Query q = em.createQuery("SELECT us"
                + " FROM "
                + " UserSkill us"
                + " WHERE us.user.id = :id ", UserSkill.class);
        q.setParameter("id", id);
        List<UserSkill> list = q.getResultList();
        return list;
    }


    public boolean insertUserSkill(UserSkill u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    public boolean updateUserSkill(UserSkill u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        EntityManager em = em();
        UserSkill userSkill=em.find(UserSkill.class,id);
        em.getTransaction().begin();
        em.remove(userSkill);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

}
