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

    public static void main(String[] args){
        UserDaoInter userdao = Context.instanceUserDao();
//User u =userdao.findByEmailAndPassword("test@mail.ru","123123");

        User u = new User();
        u.setName("test");
        u.setEmail("test@mail.ru");
        u.setPassword("123123");
        userdao.addUser(u);


    }

}
