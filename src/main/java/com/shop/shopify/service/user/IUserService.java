package com.shop.shopify.service.user;

import com.shop.shopify.dto.UserDto;
import com.shop.shopify.model.User;
import com.shop.shopify.request.CreateUserRequest;
import com.shop.shopify.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);

    User createUser(CreateUserRequest request);

    User updateUser(UserUpdateRequest request, Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);
}
