package com.ecommerce.order_service.services;

import java.util.List;

import com.ecommerce.order_service.dtos.OrderRequest;
import com.ecommerce.order_service.dtos.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    void deleteOrder(Long id);
}
