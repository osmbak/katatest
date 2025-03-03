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
    public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product products;
        private int quantity;
        private double price;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;



}
