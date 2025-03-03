package com.kataTest.back;

import com.kataTest.back.enteties.InventoryStatus;
import com.kataTest.back.enteties.Product;
import com.kataTest.back.enteties.Role;
import com.kataTest.back.enteties.User;
import com.kataTest.back.repositoy.ProductRepository;
import com.kataTest.back.repositoy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@SpringBootApplication(scanBasePackages = "com.kataTest.back")
public class KataTestApplication {

	private final PasswordEncoder passwordEncoder;
private final UserRepository userRepository;
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(KataTestApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		Optional<User> user = userRepository.findByEmail("ss@ss");
		boolean userExist = user.isPresent();
		if(!userExist) {
			User u = new User();
			u.setId(6L);
			u.setEmail("ss@ss");
			u.setPassword(passwordEncoder.encode("ss"));

			u.setFirstName("ss");
			u.setLastName("ss");
			u.setRole(Role.ADMIN);
			userRepository.save(u);
		}
		List<User> str = userRepository.findAll();
		str.forEach(System.out::println);

		String imagePath = "src/main/resources/static/s5.jpg"; // Modifie le chemin
		byte[] imageData = Files.readAllBytes(Path.of(imagePath));


		Product product = Product.builder()
				.code("1code")
				.category("accessoire")
				.name("casque")
				.inventoryStatus(InventoryStatus.INSTOCK)
				.internalReference("ref1")
				.rating(11)
				.quantity(10)
				.image(imageData)
				.build();
		productRepository.save(product);


		Product product2 = Product.builder()
				.code("2code")
				.category("besoin")
				.name("casque")
				.inventoryStatus(InventoryStatus.INSTOCK)
				.internalReference("ref2")
				.rating(11)
				.quantity(5)
				.image(imageData)
				.build();

		productRepository.save(product2);
		List<Product> strProduct = productRepository.findAll();
		strProduct.forEach(System.out::println);

		return args -> {
			System.out.println("Exécution personnalisée avec ApplicationRunner !");
		};
	}
}
