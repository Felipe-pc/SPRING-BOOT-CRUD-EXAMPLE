package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UsersEntity;

public class IUserService {
	
	public List<UsersEntity> findAll();

	public UsersEntity findById(Long id);

	public UsersEntity add(UsersEntity user);

	public UsersEntity update(UsersEntity user);

	public void remove(Long id);

}
