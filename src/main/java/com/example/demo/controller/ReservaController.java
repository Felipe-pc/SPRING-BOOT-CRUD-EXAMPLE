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
	
	
	@GetMapping
	public List<ReservasEntity> findAll(){
		return reservaService.findAll();
	}

	@GetMapping("/{sala}")
	public List<ReservasEntity> findBySalaEquals(@PathVariable Integer sala) {
		return reservaRepo.findBySalaEquals(sala);
	}

	
	@GetMapping("/fechaBetween/{fecha1}/{fecha2}")
	List<ReservasEntity> findByFechaBetween(@PathVariable("fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha1,
			@PathVariable("fecha2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha2) {
		return reservaRepo.findByFechaBetween(fecha1, fecha2);
	}

	@GetMapping("/motivos/null")
	List<ReservasEntity> findByMotivoIsNull() {
		return reservaRepo.findByMotivoIsNull();
	}

	@GetMapping("/aceptada")
	List<ReservasEntity> findByAceptadaTrue() {
		return reservaRepo.findByAceptadaTrue();
	}

	@GetMapping("/fechas/{fecha}")
	List<ReservasEntity> findByFechaGreaterThan(@PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fecha) {
		return reservaRepo.findByFechaGreaterThan(fecha);
	}
	
	@GetMapping("/fechitas")
	List<ReservasEntity> findAllfechas(){
		return reservaRepo.findAll();
	}
	
	@GetMapping("/prueba/{nombre}/{apellido}")
	public List<ReservasEntity> findReservasByUser(@PathVariable("nombre") String nombre,@PathVariable("apellido") String apellido){
		return reservaRepo.findReservasByUser(nombre,apellido);
	}
	
	@PostMapping("reservar")
	public ReservasEntity add(@RequestBody ReservasEntity reserva ) {
		return reservaService.add(reserva);
	}

}
