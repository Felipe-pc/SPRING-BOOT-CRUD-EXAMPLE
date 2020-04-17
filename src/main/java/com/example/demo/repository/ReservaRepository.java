package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReservasEntity;

public interface ReservaRepository extends JpaRepository<ReservasEntity, Long> {

	List<ReservasEntity> findBySalaEquals(Integer sala);

	List<ReservasEntity> findByFechaBetween(Date fecha1, Date fecha2);

	List<ReservasEntity> findByFechaGreaterThan(Date fecha);

	List<ReservasEntity> findByMotivoIsNull();

	List<ReservasEntity> findByAceptadaTrue();
	
	List<ReservasEntity> findAll();
	
	@Query(value = "SELECT reserva.id, reserva.aceptada, reserva.fecha, reserva.motivo, reserva.sala, reserva.usuario  FROM reserva INNER JOIN usuarios ON reserva.usuario= usuarios.id WHERE usuarios.nombre LIKE  ?1% AND usuarios.apellidos LIKE ?2%", nativeQuery = true)
	List<ReservasEntity> findReservasByUser(String nombre, String apellido);

}
