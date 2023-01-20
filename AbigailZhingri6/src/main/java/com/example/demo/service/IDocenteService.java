package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Docente;



public interface IDocenteService {
	

public List<Docente>findAll();
	
	public Docente findById(Integer id);
	
    public Docente save(Docente docente);

    public void delete(Integer id);

}
