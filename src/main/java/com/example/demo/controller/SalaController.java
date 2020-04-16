package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SalasEntity;
import com.example.demo.service.ISalaService;

@RestController
@RequestMapping("/salas")
public class SalaController {
	
	@Autowired
	@Qualifier("SalaServiceBdd")
	private ISalaService salaService;
	
	@GetMapping
	public List<SalasEntity> findAll() {
		return salaService.findAll();
	}

	@GetMapping("/{id}")
	public SalasEntity findById(@PathVariable Long id) {
		return salaService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SalasEntity add(@RequestBody SalasEntity sala) {
		return salaService.add(sala);
	}

	@PutMapping
	public SalasEntity update(@RequestBody SalasEntity sala) {
		return salaService.update(sala);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		salaService.remove(id);
	}

}
