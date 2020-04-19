package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
	
	// Metodos/Query creados para realizar las consultas en el controlador

	UsersEntity findByNombreIgnoreCaseAndApellidosLikeIgnoreCase(String nombre, String apellido);

	List<UsersEntity> findAllByOrderByNombre();

	List<UsersEntity> findByEdadLessThanEqual(Long edad);

}
