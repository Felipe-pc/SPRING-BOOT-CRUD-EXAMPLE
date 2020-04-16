package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;


@Service("UserServiceBdd")
public class UserServiceBddImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UsersEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UsersEntity findById(Long id) {
		Optional<UsersEntity> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public UsersEntity add(UsersEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UsersEntity update(UsersEntity user) {
		Optional<UsersEntity> userBdd = userRepository.findById(user.getId());

		if (userBdd.isPresent()) {
			userBdd.get().setNombre(user.getNombre());
			return userRepository.save(userBdd.get());
		}

		return null;
	}

	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
	}

}
