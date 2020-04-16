package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UsersEntity;
import com.example.demo.service.IUserService;


@Service("UserServiceBdd")
public class UserServiceImpl implements IUserService {
	
	public List<UsersEntity> users = new ArrayList<>();

	@Override
	public List<UsersEntity> findAll() {
		return users;
	}

	@Override
	public UsersEntity findById(Long id) {
		Optional<UsersEntity> user = users.stream().filter(p -> p.getId() == id).findFirst();

		return user.isPresent() ? user.get() : null;
	}

	@Override
	public UsersEntity add(UsersEntity user) {
		users.add(user);

		return user;
	}

	@Override
	public UsersEntity update(UsersEntity user) {
		AtomicInteger index = new AtomicInteger();
		users.stream().forEach(p -> {
			if (p.getId() == user.getId()) {
				p.setNombre(user.getNombre());
				p.setApellidos(user.getApellidos());
				p.setEmail(user.getEmail());
				p.setFechaNacimiento(user.getFechaNacimiento());
				p.setEdad(user.getEdad());
				users.set(index.get(), p);
			}
			index.getAndIncrement();
		});

		return user;
	}

	@Override
	public void remove(Long id) {
		Optional<UsersEntity> user = users.stream().filter(p -> p.getId() == id).findFirst();

		if (user.isPresent()) {
			users.remove(user.get());
		}
	}
	
	

}
