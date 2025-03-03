package com.kataTest.back.service;

import com.kataTest.back.enteties.Cart;
import com.kataTest.back.enteties.CartItem;
import com.kataTest.back.enteties.Product;

import java.util.Optional;

public interface CartService {

     Cart addProductToCart(Long cartId, Long productId, int quantity) ;

     Cart updateCartItemQuantity(Long itemId, int newQuantity , String operation);

     void removeCartItem(Long itemId);

     Cart getCart(Long cartId);

}
