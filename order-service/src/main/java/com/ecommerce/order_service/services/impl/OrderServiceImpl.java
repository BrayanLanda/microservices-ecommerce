package com.ecommerce.order_service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.order_service.dtos.OrderRequest;
import com.ecommerce.order_service.dtos.OrderResponse;
import com.ecommerce.order_service.exceptions.ResourceNotFoundException;
import com.ecommerce.order_service.mappers.OrderMapper;
import com.ecommerce.order_service.models.Order;
import com.ecommerce.order_service.repositories.OrderRepository;
import com.ecommerce.order_service.services.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        log.info("Placing a new order");
        Order order = orderMapper.toOrder(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());
        Order savedOrder = orderRepository.save(order);
        log.info("Order saved successfully. Id {}", savedOrder.getId());
        return orderMapper.toOrderResponse(savedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        return orderMapper.toOrderResponse(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id))
            throw new ResourceNotFoundException("Order", "id", id);

        orderRepository.deleteById(id);
        log.info("Order deleted successfully. Id {}", id);
    }

}
