package co.com.ingeneo.nicocine;

import co.com.ingeneo.nicocine.entity.Ciudad;
import co.com.ingeneo.nicocine.entity.Empleado;
import co.com.ingeneo.nicocine.entity.Region;
import co.com.ingeneo.nicocine.entity.Sucursal;
import co.com.ingeneo.nicocine.service.EmpleadoService;
import co.com.ingeneo.nicocine.service.SucursalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class NicocineApplicationTests {


	@Autowired
	SucursalService sucursalService;

	@Autowired
	EmpleadoService empleadoService;

	@Test
	void contextLoads() {
	}
	

	@Test
	void createEmpleado() {
		Empleado e1 = new Empleado();
		e1.setApellido("Prueba Empleado 1");
		e1.setDocumento("123456");
		e1.setNombre("Prueba Empleado 111111");
		empleadoService.guardar(e1);
	}


}
