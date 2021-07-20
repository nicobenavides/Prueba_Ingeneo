package co.com.ingeneo.nicocine.service;

import co.com.ingeneo.nicocine.entity.Empleado;
import co.com.ingeneo.nicocine.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

	@Autowired
	IEmpleadoRepository iEmpleadoRepository;

	public List<Empleado> obtenerTodos() {
		List<Empleado> lista = iEmpleadoRepository.findAll();
		return lista;
	}

	public void guardar(Empleado sucursal) {
		iEmpleadoRepository.save(sucursal);
	}

	public void actualizar(List<Empleado> sucursal) {
		for(Empleado s: sucursal) {
			Empleado s2 = iEmpleadoRepository.getById(s.getId());
			iEmpleadoRepository.save(s2);
		}
	}

}
