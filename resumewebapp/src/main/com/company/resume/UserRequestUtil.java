package com.company.resume;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRequestUtil {
    public static void checkRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException {
        String userIdStr = request.getParameter("id");
        if (userIdStr == null || userIdStr.trim().isEmpty()) {

            throw new IllegalArgumentException("Specify id");
        }
    }
    public static User processRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException {
            UserRequestUtil.checkRequest(request, response);
            Integer userId = Integer.parseInt(request.getParameter("id"));
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            return u;
    }



}

//    }
//    User u = null;
//    String idStr = request.getParameter("id");
//    Integer id = null;
//    if (idStr != null && !idStr.trim().isEmpty()) {
//        try {
//            id = Integer.parseInt(idStr);
//
//            u = userDao.getById(id);
//        } catch (Exception ex) {
//            out.print("User id duzgun yazilmayib");
//        }
//    } else {
//        out.println("User id bosdur");
//    }
//
//    if (u != null) {
//


