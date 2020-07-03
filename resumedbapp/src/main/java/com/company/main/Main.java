/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;


import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

/**
 * @author xeyal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userdao = Context.instanceUserDao();
User u =userdao.findByEmailAndPassword("xeyalbey@mail.ru4","123123");

//        User u = new User();
//        u.setName("Xeyal155");
//        u.setEmail("xeyalbey@mail.ru4");
//        u.setPassword("123123");
//        userdao.updateUser(u);

        System.out.println(u.getName());
    }

}
