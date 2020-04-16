package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReservasEntity;

public interface ReservaRepository extends JpaRepository<ReservasEntity, Long> {

}
