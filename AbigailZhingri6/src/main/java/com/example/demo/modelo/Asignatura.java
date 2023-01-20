package com.example.demo.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "asignatura")
public class Asignatura {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_asignatura")
	private Integer id_asignatura;
	 
	 @Column(name="nombre_asig")
	private String nombre_asig;
	 
	 @Column(name="carrera")
	private String carrera; 
	 
	 @Column(name="hora_ini")
	private String hora_ini;
	 
	@Column(name="hora_fin")
	private String hora_fin;
	
	  

	  @ManyToOne
	    @JoinColumn (name = "id_docente", referencedColumnName = "id_docente")
	    private Docente docente;
	public Integer getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Integer id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public String getNombre_asig() {
		return nombre_asig;
	}

	public void setNombre_asig(String nombre_asig) {
		this.nombre_asig = nombre_asig;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}


	
	
	  

}
