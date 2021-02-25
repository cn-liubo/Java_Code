package com.liu.test;

import com.liu.pojo.Cart;
import com.liu.pojo.CartItem;
import com.liu.service.OrderService;
import com.liu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }
}