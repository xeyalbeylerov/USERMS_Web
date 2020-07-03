/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.util.List;
import com.company.entity.User;
import com.company.entity.UserSkill;

import javax.persistence.EntityManager;

/**
 *
 * @author xeyal
 */
public interface UserDaoInter {

     List<User> getAll(String name,String surname,Integer nationalityId);

     User findByEmailAndPassword(String email,String password);

     User findByEmail(String email);

     User getById(int userId);

     boolean addUser(User u);

     boolean updateUser(User u);

     boolean removeUser(int i);

}
