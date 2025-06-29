package com.shop.shopify.service.order;

import com.shop.shopify.dto.OrderDto;
import com.shop.shopify.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);
}
