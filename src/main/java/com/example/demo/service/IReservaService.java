package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ReservasEntity;

public interface IReservaService {
	
	/**
	 * Metodo que devuelve la lista de todas las reservas
	 * @return la lista de reservas
	 */
	public List<ReservasEntity> findAll();
	
	/**
	 * Metodo que añade una nueva reserva
	 * @param reserva
	 * @return la nueva reserva
	 */
	public ReservasEntity add(ReservasEntity reserva);
	

}
