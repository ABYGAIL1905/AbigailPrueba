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
import com.example.demo.service.IAsignaturaService;

@CrossOrigin (origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class AsignaturaControlador {
	
	private List<Asignatura> cli = new ArrayList<>();
	@Autowired
	private IAsignaturaService iasignatura;
	
	//retorna todos
		@GetMapping("/asignatura")
		public List<Asignatura>index(){
			return iasignatura.findAll();	
		}
		
		//retorna uno
		@GetMapping("/asignatura/{id}")
		public Asignatura show(@PathVariable Integer id){
			return iasignatura.findById(id);
		}
		
		//inserta un cliente
		@PostMapping("/asignatura")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Asignatura saves(@Valid @RequestBody Asignatura asignatura) {
	        return iasignatura.save(asignatura);
	    }
		
		//elimina 
		@DeleteMapping("/asignatura/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public ResponseEntity<Asignatura>delete(@ Valid @PathVariable Integer id) {
			
			cli.stream().filter(currentUser -> currentUser.getId_asignatura() == id)
					.findFirst()
					.orElseThrow(() -> new RuntimeException("No existe la asignatura"));
					iasignatura.delete(id);
					return ResponseEntity.ok().build();
		}
		
		//actualiza 
		@PutMapping("/asignatura/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Integer id){
			Asignatura asigactual = iasignatura.findById(id);
			asigactual.setNombre_asig(asignatura.getNombre_asig());
			asigactual.setCarrera(asignatura.getCarrera());
			asigactual.setHora_ini(asignatura.getHora_ini());
			asigactual.setHora_fin(asignatura.getHora_fin());
			return iasignatura.save(asigactual);
		}

}
