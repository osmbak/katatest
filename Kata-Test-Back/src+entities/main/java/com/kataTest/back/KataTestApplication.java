package com.kataTest.back;

import com.kataTest.back.enteties.Role;
import com.kataTest.back.enteties.User;
import com.kataTest.back.repositoy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor

@SpringBootApplication
public class KataTestApplication {

private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(KataTestApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		RestTemplate restTemplate = new RestTemplate();

		User u = new User();
		u.setId(6);
		u.setEmail("ss@ss");
		u.setPassword("ss");
		u.setFirstName("ss");
		u.setLastName("ss");
		u.setRole(Role.ADMIN);
		userRepository.save(u);

		List<User> str = userRepository.findAll();
		str.forEach(System.out::println);
		return args -> {
			System.out.println("Exécution personnalisée avec ApplicationRunner !");
		};
	}
}
