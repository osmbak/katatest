package com.kataTest.back.enteties;

import jakarta.persistence.ManyToOne;

public class Cart {

    private Long id;

    @ManyToOne()
    private String code;

    @ManyToOne()
    private Product name;

}
