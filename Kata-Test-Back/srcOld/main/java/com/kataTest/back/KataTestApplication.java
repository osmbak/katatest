package com.kataTest.back;

import com.kataTest.back.enteties.Product;
import com.kataTest.back.repositoy.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequiredArgsConstructor

@SpringBootApplication
public class KataTestApplication {

private final IUserRepository userRepository;
	private final IProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(KataTestApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		RestTemplate restTemplate = new RestTemplate();



		Product product = new Product();
		product.setCode("ref101");
		product.setCategory("IT");
		product.setName("PC");
		product.setQuantity(11);
		product.setPrice(new BigDecimal(20));
		product.setRating(22);
		productRepository.save(product);


		return args -> {
			System.out.println("Exécution personnalisée avec ApplicationRunner !");
		};
	}
}
