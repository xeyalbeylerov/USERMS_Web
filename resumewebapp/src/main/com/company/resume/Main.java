package com.company.resume;

import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;

public class Main {
    public static void main(String[] args) {
        UserDaoInter daoInter= Context.instanceUserDao();

        System.out.println(daoInter.getAll(null,null,null));
    }
}
