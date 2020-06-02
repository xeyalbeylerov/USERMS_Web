package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;

import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "IndexController", urlPatterns = {"/index.html"})
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDaoInter userDao = Context.instanceUserDao();


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
