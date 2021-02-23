package com.liu.service;

import com.liu.pojo.Cart;

public interface OrderService {

    String createOrder(Cart cart, Integer userId);
}
