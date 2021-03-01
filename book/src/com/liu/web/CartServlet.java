package com.liu.web;

import com.google.gson.Gson;
import com.liu.pojo.Book;
import com.liu.pojo.Cart;
import com.liu.pojo.CartItem;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById()，得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.addItem()，添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //最后一个添加的商品名称
        request.getSession().setAttribute("lastName", cartItem.getName());

        //返回购物车总的商品数量和最后的一个添加的商品名称
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        response.getWriter().write(resultMapJsonString);
    }

    /**
     * 加入购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById()，得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.addItem()，添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);

//        System.out.println("请求头Referer的值" + request.getHeader("Referer"));

        //重定向会原来商品所在的地址页面
        response.sendRedirect(request.getHeader("Referer"));

        //最后一个添加的商品名称
        request.getSession().setAttribute("lastName", cartItem.getName());
    }

    /**
     * 删除商品项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            //删除购物车商品项
            cart.deleteItem(id);
            //重定向回原来的购物车展示界面
            response.sendRedirect(request.getHeader("Referer"));
        }

    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            //重定向回原来的购物车展示界面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数，商品编号，商品数量
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 0);
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if(cart != null) {
            cart.updateCount(id, count);
            //重定向回原来的购物车展示界面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
