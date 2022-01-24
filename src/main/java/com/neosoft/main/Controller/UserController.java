package com.neosoft.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.main.Model.User;
import com.neosoft.main.Services.UserServiceI;

@RestController
public class UserController {

	@Autowired
	UserServiceI userService;

	@PostMapping("/api/user")
	public String register(@RequestBody User u) {
		userService.saveUser(u);
		return "Data Saved";
	}

	@DeleteMapping("/api/user/{uid}")
	public ResponseEntity<?> deleteUserId(@PathVariable("uid") int uid) {
		User emp = userService.getUserById(uid);
		if (emp != null) {
			userService.deleteUserById(uid);
			return new ResponseEntity<String>("User data deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User not found of this id", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/api/usersoft/{uid}")
	public ResponseEntity<?> softDeleteById(@PathVariable("uid") int uid) {
		User u = userService.getUserById(uid);
		if (u != null) {
			u.setDeleted(true);
			User savedUser = userService.softDeleteUser(u);
			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/api/user/{name}")
	public ResponseEntity findByUnameOrSurnameOrPincode(@PathVariable("name") String name) {

		List<User> user = userService.findUserByName(name);
		if (!user.isEmpty()) {

			return new ResponseEntity(userService.findUserByName(name), HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/api/UserBysortDob")
	public ResponseEntity<?> getUserByUsingSortingField() throws BusinessException {
		try {
			List<User> list = userService.getUserByUsingSortingField();
			if (!list.isEmpty()) {
				return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("list is empty", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			ControllerException ce = new ControllerException("611", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/api/UserBysortJoinDate")
	public ResponseEntity<?> getUserByUsingSortingFieldJoin() throws BusinessException {
		try {
			List<User> list = userService.getUserByUsingSortingFieldJoiningDate();
			if (!list.isEmpty()) {
				return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("list is empty", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			ControllerException ce = new ControllerException("611", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
}