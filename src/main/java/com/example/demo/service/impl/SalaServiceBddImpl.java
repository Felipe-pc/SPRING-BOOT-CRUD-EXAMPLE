package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SalasEntity;
import com.example.demo.repository.SalaRepository;
import com.example.demo.service.ISalaService;

@Service("ServiceBdd2")
public class SalaServiceBddImpl implements ISalaService {
	
	@Autowired
	private SalaRepository salaRepository;
	
	/**
	 * Metodo que devuelve una lista de todas las salas
	 */
	
	@Override
	public List<SalasEntity> findAll() {
		return salaRepository.findAll();
	}
	
	/**
	 * Metodo que devuelve la sala segun el id insertado
	 */

	@Override
	public SalasEntity findById(Long id) {
		Optional<SalasEntity> sala = salaRepository.findById(id);
		return sala.isPresent() ? sala.get() : null;
	}
	
	/**
	 * Metodo que añade una sala
	 */

	@Override
	public SalasEntity add(SalasEntity sala) {
		return salaRepository.save(sala);
	}
	
	/**
	 * Metodo que modifica una sala
	 */

	@Override
	public SalasEntity update(SalasEntity sala) {
		Optional<SalasEntity> salaBdd = salaRepository.findById(sala.getId());

		if (salaBdd.isPresent()) {
			salaBdd.get().setNombre(sala.getNombre());
			salaBdd.get().setNumero(sala.getNumero());
			salaBdd.get().setLugar(sala.getLugar());
		
			return salaRepository.save(salaBdd.get());
		}

		return null;
	}
	
	/**
	 * Metodo que elimina una sala
	 */

	@Override
	public void remove(Long id) {
		salaRepository.deleteById(id);
	}

}
