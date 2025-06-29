package com.shop.shopify.dto;

import com.shop.shopify.model.Cart;
import com.shop.shopify.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}
