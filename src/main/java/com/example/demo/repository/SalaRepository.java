package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SalasEntity;

public interface SalaRepository extends JpaRepository<SalasEntity, Long> {

}
