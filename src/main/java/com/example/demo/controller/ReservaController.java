package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ReservasEntity;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.IReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired 
	private IReservaService reservaService;

	@Autowired
	private ReservaRepository reservaRepo;
	
	/**
	 * Get all reservas
	 * @return todas las reservas
	 */
	@GetMapping
	public List<ReservasEntity> findAll(){
		return reservaService.findAll();
	}
	
	/**
	 * Devuelve las reservas segun el id de la sala
	 * @param sala
	 * @return la lista de reservas
	 */

	@GetMapping("/{sala}")
	public List<ReservasEntity> findBySalaEquals(@PathVariable Integer sala) {
		return reservaRepo.findBySalaEquals(sala);
	}

	/**
	 * Devuelve las reservas realizadas entre la primera fecha y la segunda
	 * @param fecha1 primera fecha que insertamos
	 * @param fecha2 segunda fecha que insertamos 
	 * @return lista de reservas entre dichas fechas
	 */
	@GetMapping("/fechaBetween/{fecha1}/{fecha2}")
	List<ReservasEntity> findByFechaBetween(@PathVariable("fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha1,
			@PathVariable("fecha2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha2) {
		return reservaRepo.findByFechaBetween(fecha1, fecha2);
	}
	
	/**
	 * Devuelve las reservas con motivos nulos
	 * @return la lista de reservas
	 */

	@GetMapping("/motivos/null")
	List<ReservasEntity> findByMotivoIsNull() {
		return reservaRepo.findByMotivoIsNull();
	}
	
	/**
	 * Devuelve las reservas que han sido aceptadas (true)
	 * @return la lista de reservas
	 */

	@GetMapping("/aceptada")
	List<ReservasEntity> findByAceptadaTrue() {
		return reservaRepo.findByAceptadaTrue();
	}
	
	/**
	 * Devuelve las reservas con fechas posteriores a la que se inserta
	 * @param fecha que insertamos 
	 * @return la lista de reservas
	 */

	@GetMapping("/fechas/{fecha}")
	List<ReservasEntity> findByFechaGreaterThan(@PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fecha) {
		return reservaRepo.findByFechaGreaterThan(fecha);
	}
	
	/**
	 * Devuelve las reservas realizadas segun el nombre y apellido
	 * @param nombre 
	 * @param apellido
	 * @return la lista de reservas
	 */
	@GetMapping("/prueba/{nombre}/{apellido}")
	public List<ReservasEntity> findReservasByUser(@PathVariable("nombre") String nombre,@PathVariable("apellido") String apellido){
		return reservaRepo.findReservasByUser(nombre,apellido);
	}
	
	/**
	 * Post que realizamos para agregar una reserva de una sala
	 * @param reserva
	 * @return la reserva insertada
	 */
	
	@PostMapping("reservar")
	public ReservasEntity add(@RequestBody ReservasEntity reserva ) {
		return reservaService.add(reserva);
	}

}
