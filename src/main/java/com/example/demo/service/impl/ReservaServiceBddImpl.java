package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.ReservasEntity;
import com.example.demo.entity.SalasEntity;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.IReservaService;

@Service("ServiceBdd3")
public class ReservaServiceBddImpl implements IReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public List<ReservasEntity> findAll() {
		return reservaRepository.findAll();
	}
	
	@Override
	public ReservasEntity add(ReservasEntity reserva) {
		return reservaRepository.save(reserva);
	}
	
	
	
	

}
