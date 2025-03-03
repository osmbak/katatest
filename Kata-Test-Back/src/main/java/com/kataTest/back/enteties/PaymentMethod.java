package com.kataTest.back.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class PaymentMethod {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String libille;
}
