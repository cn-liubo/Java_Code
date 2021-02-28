package com.liu.web;

import com.liu.pojo.Book;
import com.liu.pojo.Page;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    //处理分页功能
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用bookService.page(pageNo, pageSize)，返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3.保存Page对象到Request对象中
        request.setAttribute("page", page);
        //4.请求转发到  /pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo += 1;
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //2.调用bookService.addBook()保存图书
        bookService.addBook(book);
        //3.跳动图书列表页面 book/manager/bookServlet?action=list
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request, response);//请求转发的/表示到工程名

//        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);//重定向的/表示到端口号，需要加上工程名
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数id，图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.调用bookService.deleteBookById()，删除图书
        bookService.deleteBookById(id);
        //3.重定向回图书列表管理页面  book/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //2.调用bookService.updateBook()修改图书
        bookService.updateBook(book);
        //3.重定向到图书列表管理页面  /pages/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数图书的编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.调用bookService.queryBookById()查询图书
        Book book = bookService.queryBookById(id);
        //3.保存到图书到Request域中
        request.setAttribute("book", book);
        //4.请求转发  /pages/manager/book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过bookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        request.setAttribute("books", books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

}
