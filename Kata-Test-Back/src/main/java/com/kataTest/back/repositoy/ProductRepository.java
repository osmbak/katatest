package com.kataTest.back.repositoy;


import com.kataTest.back.enteties.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository   extends JpaRepository<Product,Long> {
}
