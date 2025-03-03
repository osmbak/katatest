package com.kataTest.back.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name="ORDER_C")
public class Order {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long Id;

        @ManyToOne
        public User user ;

        public BigDecimal TotalPrice ;
        public LocalDateTime datePaiement ;

@ManyToOne
        public PaymentMethod PaymentMethod ;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    String status;
        
}
