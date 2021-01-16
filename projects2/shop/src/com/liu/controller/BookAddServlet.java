package com.liu.controller;

import com.liu.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookAddServlet", urlPatterns = "/add")
public class BookAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = null;
        BookDao dao = new BookDao();
        int result = 0;
        bookId = request.getParameter("bookId");
        result = dao.add(bookId);
        if(result > 0) {
            request.getRequestDispatcher("/backend/add_success.jsp").forward(request, response);
        }

    }
}
