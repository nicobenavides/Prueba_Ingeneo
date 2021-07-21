package co.com.ingeneo.nicocine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.nicocine.dto.MensajeDto;
import co.com.ingeneo.nicocine.entity.Sala;
import co.com.ingeneo.nicocine.entity.Sucursal;
import co.com.ingeneo.nicocine.service.SalaService;
import co.com.ingeneo.nicocine.service.SucursalService;


@RestController
@RequestMapping("/sala")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaController {
	
	@Autowired
	SalaService salaService;
	

	@GetMapping("/list")
	public ResponseEntity<List<Sala>> obtenerLista() {
		try {
			List<Sala> lista = salaService.obtenerTodos();
			return new ResponseEntity<List<Sala>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crear(@RequestBody Sala sala) {
		try {
			salaService.guardar(sala);
			return new ResponseEntity<MensajeDto>(new MensajeDto("sala guardada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody List<Sala> sala) {

		try {
			salaService.actualizar(sala);
			return new ResponseEntity<MensajeDto>(new MensajeDto("sucursal actualizada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
