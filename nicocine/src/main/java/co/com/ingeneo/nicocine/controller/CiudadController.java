package co.com.ingeneo.nicocine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.nicocine.dto.MensajeDto;
import co.com.ingeneo.nicocine.entity.Ciudad;
import co.com.ingeneo.nicocine.service.CiudadService;


@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CiudadController {
	
	@Autowired
	CiudadService ciudadService;
	

	@GetMapping("/list")
	public ResponseEntity<List<Ciudad>> obtenerLista() {
		try {
			List<Ciudad> lista = ciudadService.obtenerTodos();
			return new ResponseEntity<List<Ciudad>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/list/{region_id}")
	public ResponseEntity<List<Ciudad>> getByRegion(@PathVariable Long region_id) {
		if (!ciudadService.existePorRegion(region_id))
			return new ResponseEntity(new MensajeDto("no existen ciudades para esta region"), HttpStatus.NOT_FOUND);
		List<Ciudad> ciudad = ciudadService.obtenerPorRegion(region_id).get();
		return new ResponseEntity<List<Ciudad>>(ciudad, HttpStatus.OK);
	}
	
	

	@PostMapping("/new")
	public ResponseEntity<?> crear(@RequestBody Ciudad ciudad) {
		try {
			ciudadService.guardar(ciudad);
			return new ResponseEntity<MensajeDto>(new MensajeDto("ciudad guardada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody List<Ciudad> ciudad) {

		try {
			ciudadService.actualizar(ciudad);
			return new ResponseEntity<MensajeDto>(new MensajeDto("ciudad actualizada"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
