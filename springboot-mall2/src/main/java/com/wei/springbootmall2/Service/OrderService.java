package com.wei.springbootmall2.Service;

import com.wei.springbootmall2.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
