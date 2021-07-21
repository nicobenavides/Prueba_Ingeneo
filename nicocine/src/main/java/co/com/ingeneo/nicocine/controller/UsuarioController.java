package co.com.ingeneo.nicocine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ingeneo.nicocine.entity.Usuario;
import co.com.ingeneo.nicocine.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioService;
	

	@PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Usuario loginUsuario){
		
		Boolean acceso = usuarioService.validar(loginUsuario);
        
        return new ResponseEntity<Boolean>(acceso, HttpStatus.OK);
    }

}
