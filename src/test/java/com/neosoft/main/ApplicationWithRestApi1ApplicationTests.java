package com.neosoft.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Iterator;
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
	
	
	List<User> user = userRepository.findAll();

	
	@Test
	void findByUsername() {
		String username = "abcd";
		Iterator<User> iterator = user.iterator();
		while (iterator.hasNext()) {
			User user1 = iterator.next();

			if (user1.getUname().equals(username)) {
				assertThat(((User) user).getUname()).isEqualTo(username);
			}
		}

		while(iterator.hasNext())
		{
			User u=iterator.next();
			
			if(u.getSurname().equals(username))
			{
				assertThat(((User) u).getUname()).isEqualTo(username);

			}
		}
	}

	@Test
	void findByUsernameNotExits() {
		String username = "pqrs";
		Iterator<User> itr = user.iterator();

		while(itr.hasNext())
		{
			User u=itr.next();
			
			if(u.getSurname().equals(username))
			{
				assertThat(((User) u).getUname()).isEqualTo(username);

			}
			assertNull(u);

		}
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
