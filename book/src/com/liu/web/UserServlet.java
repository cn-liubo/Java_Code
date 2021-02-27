package com.liu.web;

import com.google.gson.Gson;
import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import com.liu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数username
        String username = request.getParameter("username");
        //调用userService.existsUsername()
        boolean existsUsername = userService.existUsername(username);
        //把返回的结果封装成Map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
    }


        /**
         * 注销
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session中的用户登陆的信息（或者销毁session）
        request.getSession().invalidate();
        //2.重定向到首页（或登陆页面）
        response.sendRedirect(request.getContextPath());
    }

        /**
         * 处理登录的功能
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用service处理登录业务
        User loginUser = userService.login(new User(null, username, password, null));
        //如果登陆null，说明登录失败
        if(loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);

            //跳回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //登录成功
            //保存用户的登陆信息到session域中
            request.getSession().setAttribute("user", loginUser);
            //跳到登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 处理注册的功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");


        /*Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + Arrays.asList(entry.getValue()));
        }*/
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());


        //2.检查验证码是否正确 == 写死，要求验证码为abcde
        if(token != null && token.equalsIgnoreCase(code)) {
            //3.检查用户名是否可用
            if(userService.existUsername(username)) {
                System.out.println("用户名[" + username + "]已存在！");

                //把回写信息保存到request域中
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("username", username);
                request.setAttribute("email", email);

                //跳到注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //调用service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            //把回写信息保存到request域中
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);

            //跳到注册页面
            System.out.println("验证码[" + code + "]错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }


}
