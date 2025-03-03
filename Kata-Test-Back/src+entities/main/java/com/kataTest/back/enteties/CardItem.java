package com.kataTest.back.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class CardItem {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public int Quantity;
    public BigDecimal Price;
    @ManyToMany
    public List<Product> Product;
}
