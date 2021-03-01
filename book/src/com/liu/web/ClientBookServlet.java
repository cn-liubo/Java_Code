package com.liu.web;

import com.liu.pojo.Book;
import com.liu.pojo.Page;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BookServlet{

    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用bookService.page(pageNo, pageSize)，返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3.保存Page对象到Request对象中
        request.setAttribute("page", page);
        //4.请求转发到  /pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);


        //2.调用bookService.page(pageNo, pageSize)，返回Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格参数，追加到分页条的地址参数中
        if(request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        //如果有最大价格参数，追加到分页条的地址参数中
        if(request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3.保存Page对象到Request对象中
        request.setAttribute("page", page);
        //4.请求转发到  /pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
