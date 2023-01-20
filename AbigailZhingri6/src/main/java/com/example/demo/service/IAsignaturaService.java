package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Asignatura;



public interface IAsignaturaService {
	

public List<Asignatura>findAll();
	
	public Asignatura findById(Integer id);
	
    public Asignatura save(Asignatura asignatura);

    public void delete(Integer id);

}
