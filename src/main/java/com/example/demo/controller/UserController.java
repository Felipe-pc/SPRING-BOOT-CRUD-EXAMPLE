package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	@Qualifier("UserServiceBdd")
	private IUserService userService;

	@Autowired
	private UserRepository userRepo;
	
	/**
	 * Devuelve una lista de todos los usuarios
	 * @return la lista de usuarios
	 */

	@GetMapping
	public List<UsersEntity> findAll() {
		return userService.findAll();
	}
	
	/**
	 * Devuelve el usuario segun el nombre y apellido insertado, ignorando mayusculas
	 * @param nombre
	 * @param apellido
	 * @return el usuario
	 */

	@GetMapping("/nombres/{nombre}/{apellido}")
	public UsersEntity findByNombreAndApellido(@PathVariable("nombre") String nombre,
			@PathVariable("apellido") String apellido) {
		return userRepo.findByNombreIgnoreCaseAndApellidosLikeIgnoreCase(nombre, apellido);
	}
	
	/**
	 * Devuelve una lista de los usuarios ordenados alfabeticamente
	 * @return la lista de usuarios
	 */

	@GetMapping(path = "/orden")
	public List<UsersEntity> findAllByOrderByNombre() {
		return userRepo.findAllByOrderByNombre();
	}
	
	/**
	 * Devuelve una lista de usuarios que tienen una edad menor o igual a la insertada
	 * @param edad
	 * @return la lista de usuarios
	 */

	@GetMapping(path = "/edad/{edad}")
	public List<UsersEntity> findByEdadLessThanEqual(@PathVariable("edad") Long edad) {
		return userRepo.findByEdadLessThanEqual(edad);
	}
	
	/**
	 * Devuelve un usuario segun el id insertado
	 * @param id
	 * @return el usuario
	 */

	@GetMapping("/{id}")
	public UsersEntity findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	/**
	 * Post que realizamos para insertar un nuevo usuario
	 * @param user
	 * @return el nuevo usuario
	 */

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsersEntity add(@RequestBody UsersEntity user) {
		return userService.add(user);
	}
	
	/**
	 * Put para modificar el usuario que deseeamos
	 * @param user
	 * @return el usuario modificado
	 */

	@PutMapping
	public UsersEntity update(@RequestBody UsersEntity user) {
		return userService.update(user);
	}
	
	/**
	 * Delete el usuario segun el id insertado
	 * @param id
	 */

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		userService.remove(id);
	}

}
