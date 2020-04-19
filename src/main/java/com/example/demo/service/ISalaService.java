package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SalasEntity;

public interface ISalaService {

	/**
	 * Metodo que devuelve una lista de todas las salas
	 * 
	 * @return la lista de salas
	 */
	public List<SalasEntity> findAll();

	/**
	 * Metodo que devuelve una sala segun su id
	 * 
	 * @param id
	 * @return la sala
	 */
	public SalasEntity findById(Long id);

	/**
	 * Meotod que añade una sala
	 * 
	 * @param salas
	 * @return la nueva sala
	 */
	public SalasEntity add(SalasEntity salas);

	/**
	 * Metodo que modifica una sala
	 * 
	 * @param salas
	 * @return la sala modificada
	 */
	public SalasEntity update(SalasEntity salas);

	/**
	 * Metodo que elimina una sala segun el id que insertamos
	 * 
	 * @param id
	 */
	public void remove(Long id);

}
