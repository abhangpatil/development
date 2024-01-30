package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity saveUser(@RequestBody MultipartFile file){
		userService.saveUsers(file);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	
}
