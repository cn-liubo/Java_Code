package com.liu.controller;

import com.liu.dao.IdiomDao;
import com.liu.entity.Idiom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "IdiomServlet", urlPatterns = "/idiom")
public class IdiomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String idiom = request.getParameter("idiom");
        IdiomDao dao = new IdiomDao();
        if(idiom.length() == 4) {
            char c = idiom.charAt(idiom.length() - 1);
            String lastWord = Character.toString(c);
            List<Idiom> list = dao.queryIdiom();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getWordE().equals(lastWord)) {
                    request.getRequestDispatcher("/backend/idiomShow.jsp").forward(request, response);
                }
            }


        } else {
            request.getRequestDispatcher("/backend/idiomError.jsp").forward(request, response);
        }

    }
}
