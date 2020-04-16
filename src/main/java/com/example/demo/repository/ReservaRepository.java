package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReservasEntity;

public interface ReservaRepository extends JpaRepository<ReservasEntity, Long> {

		//ReservasEntity findByNumero(String numero);
	List<ReservasEntity> findAllByFecha(Date fecha);
}
