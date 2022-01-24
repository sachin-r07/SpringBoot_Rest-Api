package com.neosoft.main.ServiceImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.main.Model.User;
import com.neosoft.main.Repository.UserRepository;
import com.neosoft.main.Services.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User u) {
		userRepository.save(u);

	}

	@Override
	public List<User> getUserByUsingSortingField() {
		List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC, "udob"));
		return list;
	}

	@Override
	public List<User> getUserByUsingSortingFieldJoiningDate() {
		List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC, "uJoindate"));
		return list;
	}

	@Override
	public User getUserById(int uid) {

		User user = userRepository.getById(uid);
		return user;

	}

	@Override
	public void deleteUserById(int uid) {

		userRepository.deleteById(uid);

	}

	@Override
	public User softDeleteUser(User u) {

		User user = userRepository.save(u);

		return user;
	}

	@Override
	public List<User> findUserByName(String name) {

		List<User> user = userRepository.findByUnameOrSurnameAndPincode(name, name, name);

		return user;
	}
}