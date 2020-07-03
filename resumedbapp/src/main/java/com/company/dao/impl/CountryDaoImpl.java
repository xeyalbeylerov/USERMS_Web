package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EntityManagerUtil;
import com.company.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Khayal Baylarov
 */
public class CountryDaoImpl extends EntityManagerUtil implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<Country> country = em.createQuery("Select c from Country c", Country.class);
        em.getTransaction().commit();
        emClose(em);
        return country.getResultList();
    }


    @Override
    public Country getById(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        TypedQuery<Country> tquery = em.createQuery("Select c from Country c where c.id=:id", Country.class);
        tquery.setParameter("id", id);
        List<Country> list = tquery.getResultList();
        em.getTransaction().commit();
        emClose(em);
        return (list.size() != 0) ? list.get(0) : null;
    }

    //take id,name,nationality and update it
    @Override
    public boolean updateCountry(Country u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    //take country without id and add
    @Override
    public boolean insertCountry(Country country) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        Country country = em.find(Country.class, id);
        em.remove(country);
        em.getTransaction().commit();
        emClose(em);
        return true;
    }

}