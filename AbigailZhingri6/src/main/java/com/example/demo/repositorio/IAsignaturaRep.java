package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Asignatura;



public interface IAsignaturaRep extends JpaRepository<Asignatura, Integer> {

}
