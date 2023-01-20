package com.example.demo.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Docente;
import com.example.demo.service.IDocenteService;


@CrossOrigin (origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class DocenteControlador {
	private List<Docente> cli = new ArrayList<>();
	
	@Autowired
	private IDocenteService idocente;
	
	//retorna todos
		@GetMapping("/docente")
		public List<Docente>index(){
			return idocente.findAll();	
		}
		
		//retorna uno
		@GetMapping("/docente/{id}")
		public Docente show(@PathVariable Integer id){
			return idocente.findById(id);
		}
		
		//inserta un cliente
		@PostMapping("/docente")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Docente saves(@Valid @RequestBody Docente docente) {
	        return idocente.save(docente);
	    }
		
		//elimina 
				@DeleteMapping("/docente/{id}")
				@ResponseStatus(HttpStatus.NO_CONTENT)
				public ResponseEntity<Docente>delete(@ Valid @PathVariable Integer id) {
					
					Docente docente=cli.stream().filter(currentUser -> currentUser.getId_docente() == id)
							.findFirst()
							.orElseThrow(() -> new RuntimeException("No existe el usuario"));
							idocente.delete(id);
							return ResponseEntity.ok().build();
				}
				
				//actualiza 
				@PutMapping("/docente/{id}")
				@ResponseStatus(HttpStatus.CREATED)
				public Docente update(@RequestBody Docente docente, @PathVariable Integer id){
					Docente doactual = idocente.findById(id);
					doactual.setNombre_do(docente.getNombre_do());
					doactual.setApellido_do(docente.getApellido_do());
					doactual.setCelular_do(docente.getCelular_do());
					doactual.setEmail_do(docente.getEmail_do());
					return idocente.save(doactual);
				}
	

}
