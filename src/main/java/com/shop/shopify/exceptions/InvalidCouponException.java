package com.shop.shopify.exceptions;

public class InvalidCouponException extends RuntimeException {
  public InvalidCouponException(String message) {
    super(message);
  }
}