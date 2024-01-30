package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> saveUsers(MultipartFile file) {
		final List<User> users = parseCsvUserData(file);
		userRepository.saveAll(users);
		return users;
	}
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	private List<User> parseCsvUserData(MultipartFile file) {

		final List<User> users = new ArrayList<>();

		try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line;
			while ((line = br.readLine()) != null) {
				final String[] data = line.split(",");
				final User user = new User();
				user.setFirstName(data[1]);
				user.setLastName(data[2]);
				user.setEmail(data[3]);
				user.setGender(data[4]);
				users.add(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;

	}

}
