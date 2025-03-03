package com.kataTest.back.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

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
        public com.kataTest.back.enteties.User UserName ;

        public BigDecimal TotalPrice ;
        public Date datePaiement ;

@ManyToOne
        public PaymentMethod PaymentMethod ;
        
}
