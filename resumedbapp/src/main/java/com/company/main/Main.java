/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;


import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

/**
 * @author xeyal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userdao = Context.instanceUserDao();
//          List<User> users=userdao.getAll(null,null,0);
//           for(User user:users){
//               System.out.println( user.getProfileDesc());
//              for(UserSkill userSkill:user.getSkills()){
//                  System.out.println( userSkill.getSkill().getName());
//              }
//           }
        User u = new User();
//                u.setName("Xeyal");
//                u.setPassword("123123");
//                u.setBirthPlace(new Country(1,"Azerbaijan","Baku"));
//                u.setNationality(new Country(1,"Azerbaijan","Baku"));
//        userdao.addUser(u);
//        userdao.removeUser(22);
        List<UserSkill> skillList=userdao.getById(1).getSkills();
        for(UserSkill s:skillList){
            System.out.println(s.getSkill().getName());
        }



//        UserSkillDaoInter daoInter=Context.instanceUserSkillDao();
//        List<UserSkill> allSkillByUserId = daoInter.getAllSkillByUserId(1);
//        for(UserSkill us:allSkillByUserId){
//            System.out.println(us.getSkill().getName());
//        }


//        UserDaoInter  userDao3=Context.instanceUserDao();
//        User u3=userDao3.getById(1);
//
//        for(UserSkill s3:u3.getSkills()){
//            System.out.println("NEW "+s3.getSkill().getName());
//        }


//userdao.addUser(new User(0,"test","test","12345",false,"test@mail.ru",null,null,null,null,null,null));

//        System.out.println(u.getNationality().getName());
//        System.out.println(u.getSurname());
//       
//        List<User> lists=userdao.getAll(null,null,null);
//        for(User list:lists){
//            System.out.println("name "+list.getName());
//            System.out.println("surname "+list.getSurname());
//            System.out.println("Nat "+list.getNationality().getName());
//            
//        }


    }

}
