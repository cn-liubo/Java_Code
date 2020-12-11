package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Map map = new HashMap();
//        //int num = (int)map.get("key1");//抛出NullPointerException
//        Integer num = (Integer)map.get("key1");
//        System.out.println("hehehe......");

        String str = null;
        str.charAt(1);

    }
}
