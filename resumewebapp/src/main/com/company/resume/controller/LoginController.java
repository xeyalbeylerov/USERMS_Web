package com.company.resume.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import com.company.resume.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoInter userDao = Context.instanceUserDao();
        BCrypt.Verifyer verifyer = BCrypt.verifyer();

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            password+="xeyal";

            User user = userDao.findByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("User doesn't exists!!!");
            }
            BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
            if (!rs.verified) {
                throw new IllegalArgumentException("Password is incorrect!!!");
            }
            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("users");
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }

    }


}

