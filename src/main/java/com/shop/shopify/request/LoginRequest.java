package com.shop.shopify.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
  @NotBlank(message = "Invalid credentials")
  private String email;

  @NotBlank(message = "Invalid credentials")
  private String password;
}