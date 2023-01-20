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
@Table(name = "docente")
public class Docente {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_docente")
	private Integer id_docente;
	 
	 @Column(name="nombre_do")
	private  String nombre_do;
	 
	 @Column(name="apellido_do")
	private String apellido_do;
	 
	 @Column(name="celular_do")
    private String celular_do;
	 
	 @Column(name="email_do")
	private String email_do;
	
	 @JsonIgnore
     @OneToMany(mappedBy="docente")
  List<Asignatura> asignatura;

	public Integer getId_docente() {
		return id_docente;
	}

	public void setId_docente(Integer id_docente) {
		this.id_docente = id_docente;
	}

	public String getNombre_do() {
		return nombre_do;
	}

	public void setNombre_do(String nombre_do) {
		this.nombre_do = nombre_do;
	}

	public String getApellido_do() {
		return apellido_do;
	}

	public void setApellido_do(String apellido_do) {
		this.apellido_do = apellido_do;
	}

	public String getCelular_do() {
		return celular_do;
	}

	public void setCelular_do(String celular_do) {
		this.celular_do = celular_do;
	}

	public String getEmail_do() {
		return email_do;
	}

	public void setEmail_do(String email_do) {
		this.email_do = email_do;
	}

	public List<Asignatura> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}

	
	 
	 
	
}
