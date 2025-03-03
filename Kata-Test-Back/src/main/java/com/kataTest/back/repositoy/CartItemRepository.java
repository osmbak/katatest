package com.kataTest.back.repositoy;

import com.kataTest.back.enteties.CartItem;
import com.kataTest.back.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem , Long> {
    //List<CartItem> findByCartUser(User user);
    // Find a specific product in a user's cart
    //CartItem findByProductIdAndCartUser( Long productId , User user);
}
