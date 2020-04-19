package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;


@Service("ServiceBdd")
public class UserServiceBddImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Metodo que devuelve una lista con todos los usuarios
	 */
	@Override
	public List<UsersEntity> findAll() {
		return userRepository.findAll();
	}
	
	/**
	 * Metodo que devuelve un usuario segun el id
	 */
	@Override
	public UsersEntity findById(Long id) {
		Optional<UsersEntity> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	/**
	 * Metodo que inserta un nuevo usuario
	 */
	@Override
	public UsersEntity add(UsersEntity user) {
		return userRepository.save(user);
	}
	
	/**
	 * Metodo que modifica un usuario
	 */
	@Override
	public UsersEntity update(UsersEntity user) {
		Optional<UsersEntity> userBdd = userRepository.findById(user.getId());

		if (userBdd.isPresent()) {
			userBdd.get().setNombre(user.getNombre());
			userBdd.get().setApellidos(user.getApellidos());
			userBdd.get().setEmail(user.getEmail());
			userBdd.get().setFechaNacimiento(user.getFechaNacimiento());
			userBdd.get().setEdad(user.getEdad());
			return userRepository.save(userBdd.get());
		}

		return null;
	}
	
	/**
	 * Metodo que elimina un usuario segun la id
	 */
	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
	}

}
