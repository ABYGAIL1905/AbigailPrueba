package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Docente;
import com.example.demo.repositorio.IDocenteRep;

@Service
public class DocenteServiceIm  implements IDocenteService{

	@Autowired
	private IDocenteRep docenterep;
	@Transactional(readOnly=true)
	@Override
	public List<Docente> findAll() {
		// TODO Auto-generated method stub
		return (List<Docente> )docenterep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Docente findById(Integer id) {
		// TODO Auto-generated method stub
		return docenterep.findById(id).orElse(null);
	}

	@Override
	public Docente save(Docente docente) {
		// TODO Auto-generated method stub
		return docenterep.save(docente);
	}

	@Override
	public void delete(Integer id) {
		
	    docenterep.deleteById(id);
	}

}
