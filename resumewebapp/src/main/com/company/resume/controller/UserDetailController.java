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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("update")) {
            int id = Integer.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String profileDesc = request.getParameter("profile_description");
            String birth_date = request.getParameter("birthdate");
            String birthplace = request.getParameter("birthplace");
            String phone = request.getParameter("phone");
            User user = userDao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAddress(address);
            user.setEmail(email);
            user.setProfileDesc(profileDesc);

            Date date = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(birth_date);
            } catch (Exception ex) {
                date = user.getBirthDate();
            }
            user.setBirthDate(date);
            userDao.updateUser(user);
        } else if (action.equals("delete")) {
            int id = Integer.valueOf(request.getParameter("id"));
            userDao.removeUser(id);
        } else if (action.equals("add")) {
            //add logic here
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setName(name);
            u.setSurname(surname);
                boolean result=userDao.addUser(u);
        }
        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Specify id");
            }
            Integer userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUserDao();


            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id =" + userId);
            }

            request.setAttribute("owner", true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }


    }
}
