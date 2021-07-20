package co.com.ingeneo.nicocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ingeneo.nicocine.entity.Ciudad;
import co.com.ingeneo.nicocine.repository.ICiudadRepository;

@Service
public class CiudadService {

	@Autowired
	ICiudadRepository iCiudadRepository;

	public List<Ciudad> obtenerTodos() {
		List<Ciudad> lista = iCiudadRepository.findAll();
		return lista;
	}

	public void guardar(Ciudad ciudad) {
		iCiudadRepository.save(ciudad);
	}

	public void actualizar(List<Ciudad> ciudad) {
		for(Ciudad c: ciudad) {
			Ciudad c2 = iCiudadRepository.getById(c.getId());
			iCiudadRepository.save(c2);
		}
	}

}
