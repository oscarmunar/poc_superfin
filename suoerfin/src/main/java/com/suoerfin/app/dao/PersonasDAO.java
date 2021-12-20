package com.suoerfin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suoerfin.app.entity.Persona;

public interface PersonasDAO extends JpaRepository<Persona, Long>{

}
