package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ReservasEntity;

public interface IReservaService {
	
	public List<ReservasEntity> findAll();
	
	public ReservasEntity add(ReservasEntity reserva);
	
	//public ReservasEntity findByNumeroSala(String numero);
	

	/*public ReservasEntity findById(Long id);

	

	public ReservasEntity update(ReservasEntity reserva);

	public void remove(Long id);*/

}
