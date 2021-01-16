package com.liu.controller;

import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(
        name = "CheckCodeServlet",
        urlPatterns = "/checknumber.png",
        initParams = @WebInitParam(
                name = "code",
                value = "abcdefghigklmnopqrstuvwxyz1234567890")
)

public class CheckCodeServlet extends HttpServlet {
    private String code = "abcdefghigklmnopqrstuvwxyz1234567890";

    private int generRandomInt(int start , int range){
        return new Random().nextInt(range - start) + start;
    }

    /**
     * 随机取出四个字符
     * @return
     */
    private String randomStr(){
        StringBuffer stringBuffer = new StringBuffer();
        //取出code总字符长度
        int length = code.length();
        //随机取得0-(length-1)中的一个索引
        for (int i = 0 ; i <  4 ; i++) {
            int index = new Random().nextInt(length);
            char c = code.charAt(index);
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //随机生成四个字符
        String checkcode = randomStr();
        //把生成的字符放在session中
        request.getSession().setAttribute("checkcode",checkcode);
        //生成图片缓存
        BufferedImage imgbuf = new BufferedImage(44, 20, BufferedImage.TYPE_INT_RGB);
        //取操作缓存绘图对象
        Graphics2D g2 = (Graphics2D)imgbuf.getGraphics();
        //字符的初始偏移量
        int offset = 5;
        //字符长度
        int width = 11;
        //生成位置
        int x = offset;
        int y = 18;
        //因为缓存默认背景是黑色，改为白色
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,44,20);
        for (int i = 0 ; i < 4 ; i++){
            //随机生成红绿蓝透度四个值，每个是0-255之间的随机数
            int r = generRandomInt(0,100);
            int g = generRandomInt(0,100);
            int b = generRandomInt(0,100);
            int a = 255;
            Color c = new Color(r,g,b,a);
            //把前景色设为随机色彩
            g2.setColor(c);
            //画字符
            g2.drawString(String.valueOf(checkcode.charAt(i)),x + (width * i),y);
        }
        //把图片缓存写入流
        //设置mime类型
        response.setContentType("image/png");
        //生成图片并写到客户端
        ImageIO.write(imgbuf,"png",response.getOutputStream());
    }

    @Override
    public void init() throws ServletException {
        String c = this.getInitParameter("code");
        if (StringUtils.isNotBlank(c)) {
            this.code = c;

        }
    }

}
