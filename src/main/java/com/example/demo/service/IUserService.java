package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UsersEntity;


public interface IUserService {
	
	/**
	 * Metodo que devuelve una lista de todos los usuarios
	 * @return la lista de usuarios
	 */
	public List<UsersEntity> findAll();
	
	/**
	 * Metodo que devuelve un usuario segun el id insertado
	 * @param id
	 * @return el usuario
	 */
	public UsersEntity findById(Long id);
	
	/**
	 * Añade un usuario
	 * @param user
	 * @return el nuevo usuario
	 */
	public UsersEntity add(UsersEntity user);
	
	
	/**
	 * Modifica el usuario 
	 * @param user
	 * @return el usuario modificado
	 */
	public UsersEntity update(UsersEntity user);

		/**
		 * Metodo que elimina el usuario segun el id insertado
		 * @param id
		 */
	public void remove(Long id);

}
