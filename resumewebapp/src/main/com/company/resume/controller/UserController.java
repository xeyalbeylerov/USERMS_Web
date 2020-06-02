package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoInter userDao = Context.instanceUserDao();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String nationalityIdStr = request.getParameter("nid");
        Integer nationalityId = null;
        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
            nationalityId = Integer.parseInt(nationalityIdStr);
        }
        List<User> lists = userDao.getAll(name, surname, nationalityId);
        request.setAttribute("userList", lists);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
