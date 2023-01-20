package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Asignatura;
import com.example.demo.repositorio.IAsignaturaRep;


@Service
public class AsignaturaServiceIm implements IAsignaturaService {

	@Autowired
	private IAsignaturaRep asignaturarep;
	
	@Override
	@Transactional(readOnly=true)
	public List<Asignatura> findAll() {
		// TODO Auto-generated method stub
		return (List<Asignatura> )asignaturarep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Asignatura findById(Integer id) {
		// TODO Auto-generated method stub
		return asignaturarep.findById(id).orElse(null);
	}

	@Override
	public Asignatura save(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return asignaturarep.save(asignatura);
	}

	@Override
	public void delete(Integer id) {
		asignaturarep.deleteById(id);
	}

}
