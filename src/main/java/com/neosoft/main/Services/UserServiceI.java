package com.neosoft.main.Services;

import java.util.List;

import com.neosoft.main.Model.User;

public interface UserServiceI {

	public void saveUser(User u);

	public Object findUserByUname(String username);

	public List<User> getUserByUsingSortingField();

	List<User> getUserByUsingSortingFieldJoiningDate();

	public User getUserById(int uid);

	public void deleteUserById(int uid);

	public User softDeleteUser(User u);

}
