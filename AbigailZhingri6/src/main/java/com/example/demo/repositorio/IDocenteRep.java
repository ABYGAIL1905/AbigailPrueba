package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Docente;



public interface IDocenteRep extends JpaRepository<Docente, Integer>{

}
