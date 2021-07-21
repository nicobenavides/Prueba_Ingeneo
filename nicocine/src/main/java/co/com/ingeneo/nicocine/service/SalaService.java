package co.com.ingeneo.nicocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ingeneo.nicocine.entity.Sala;
import co.com.ingeneo.nicocine.repository.ISalaRepository;

@Service
public class SalaService {

	@Autowired
	ISalaRepository iSalaRepository;

	public List<Sala> obtenerTodos() {
		List<Sala> lista = iSalaRepository.findAll();
		return lista;
	}

	public void guardar(Sala sala) {
		iSalaRepository.save(sala);
	}

	public void actualizar(List<Sala> sala) {
		for(Sala s: sala) {
			Sala s2 = iSalaRepository.getById(s.getId());
			iSalaRepository.save(s2);
		}
	}

}
