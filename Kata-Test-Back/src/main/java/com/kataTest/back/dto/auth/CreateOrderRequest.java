package com.kataTest.back.dto.auth;
import com.kataTest.back.enteties.PaymentMethod;
import com.kataTest.back.enteties.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateOrderRequest {

    private Long userId;  // ID of the user placing the order
    private PaymentMethod paymentMethod ;
    private List<Product> orderItems;  // List of order items to be created

  }
