package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SalasEntity;

public interface ISalaService {
	
	public List<SalasEntity> findAll();

	public SalasEntity findById(Long id);

	public SalasEntity add(SalasEntity salas);

	public SalasEntity update(SalasEntity salas);

	public void remove(Long id);

}
