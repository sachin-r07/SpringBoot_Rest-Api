package com.neosoft.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.main.Model.User;
import com.neosoft.main.Repository.UserRepository;

@SpringBootTest
class ApplicationWithRestApi1ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findByUsername() {
		String username = "abcd";
		List<User> u = userRepository.findUserByUname(username);
		assertThat(((User) u).getUname()).isEqualTo(username);
	}

	@Test
	void findByUsernameNotExits() {
		String username = "pqrs";
		List<User> user = userRepository.findUserByUname(username);
		assertNull(user);
	}

	@Test
	void updateUser() {
		User user = userRepository.findById(1).get();
		System.out.println(user.getSurname());
		user.setSurname("abcderfgh");
		userRepository.save(user);
		assertNotEquals("pqrstuvex", userRepository.findById(1).get());
		System.out.println(user.getSurname());
	}

}
