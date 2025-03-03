package com.kataTest.back.dto.auth;

public class CreateOrderItemRequest {

    private Long productId;  // The ID of the product being ordered
    private int quantity;    // The quantity of the product

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
