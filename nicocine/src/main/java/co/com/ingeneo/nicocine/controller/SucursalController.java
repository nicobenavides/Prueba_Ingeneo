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
import co.com.ingeneo.nicocine.entity.Sucursal;
import co.com.ingeneo.nicocine.service.SucursalService;


@RestController
@RequestMapping("/sucursal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SucursalController {
	
	@Autowired
	SucursalService sucursalService;
	

	@GetMapping("/list")
	public ResponseEntity<List<Sucursal>> obtenerLista() {
		try {
			List<Sucursal> lista = sucursalService.obtenerTodos();
			return new ResponseEntity<List<Sucursal>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crear(@RequestBody Sucursal sucursal) {
		try {
			sucursalService.guardar(sucursal);
			return new ResponseEntity<MensajeDto>(new MensajeDto("producto guardado"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody List<Sucursal> sucursal) {

		try {
			sucursalService.actualizar(sucursal);
			return new ResponseEntity<MensajeDto>(new MensajeDto("producto actualizado"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
