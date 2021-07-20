package co.com.ingeneo.nicocine.controller;

import co.com.ingeneo.nicocine.dto.MensajeDto;
import co.com.ingeneo.nicocine.entity.Empleado;
import co.com.ingeneo.nicocine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Empleado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpleadoController {

	@Autowired
	EmpleadoService EmpleadoService;

	@GetMapping("/list")
	public ResponseEntity<List<Empleado>> obtenerLista() {
		try {
			List<Empleado> lista = EmpleadoService.obtenerTodos();
			return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crear(@RequestBody Empleado Empleado) {
		try {
			EmpleadoService.guardar(Empleado);
			return new ResponseEntity<MensajeDto>(new MensajeDto("producto guardado"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody List<Empleado> Empleado) {

		try {
			EmpleadoService.actualizar(Empleado);
			return new ResponseEntity<MensajeDto>(new MensajeDto("producto actualizado"), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
