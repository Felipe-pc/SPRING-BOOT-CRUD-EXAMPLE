package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ReservasEntity;

public interface IReservaService {
	
	public List<ReservasEntity> findAll();

	public ReservasEntity findById(Long id);

	public ReservasEntity add(ReservasEntity reserva);

	public ReservasEntity update(ReservasEntity reserva);

	public void remove(Long id);

}
