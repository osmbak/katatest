package com.kataTest.back.repositoy;

import com.kataTest.back.enteties.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}

