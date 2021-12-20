package com.suoerfin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suoerfin.app.entity.Empleado;

public interface EmpleadosDAO extends JpaRepository<Empleado, Long>{

}
