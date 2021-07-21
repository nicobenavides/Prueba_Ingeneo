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
import co.com.ingeneo.nicocine.entity.Region;
import co.com.ingeneo.nicocine.service.RegionService;


@RestController
@RequestMapping("/region")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegionController {
	
	@Autowired
	RegionService regionService;
	

	@GetMapping("/list")
	public ResponseEntity<List<Region>> obtenerLista() {
		try {
			List<Region> lista = regionService.obtenerTodos();
			return new ResponseEntity<List<Region>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crear(@RequestBody Region region) {
		try {
			regionService.guardar(region);
			return new ResponseEntity<MensajeDto>(new MensajeDto("region guardada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody List<Region> region) {

		try {
			regionService.actualizar(region);
			return new ResponseEntity<MensajeDto>(new MensajeDto("region actualizada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
