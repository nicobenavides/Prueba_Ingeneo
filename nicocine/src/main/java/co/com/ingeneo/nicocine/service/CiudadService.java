package co.com.ingeneo.nicocine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ingeneo.nicocine.entity.Ciudad;
import co.com.ingeneo.nicocine.entity.Region;
import co.com.ingeneo.nicocine.repository.ICiudadRepository;
import co.com.ingeneo.nicocine.repository.IRegionRepository;

@Service
public class CiudadService {

	@Autowired
	ICiudadRepository iCiudadRepository;
	@Autowired
	IRegionRepository iRegionRepository;

	public List<Ciudad> obtenerTodos() {
		List<Ciudad> lista = iCiudadRepository.findAll();
		return lista;
	}

	public void guardar(Ciudad ciudad) {
		iCiudadRepository.save(ciudad);
	}

	public void actualizar(List<Ciudad> ciudad) {
		for (Ciudad c : ciudad) {
			Ciudad c2 = iCiudadRepository.getById(c.getId());
			iCiudadRepository.save(c2);
		}
	}

	public boolean existePorRegion(Long region_id) {

		Optional<Region> region = iRegionRepository.findById(region_id); 
		return iCiudadRepository.existsByRegion(region);
	}

	public Optional<List<Ciudad>> obtenerPorRegion(Long region_id) {
		Optional<List<Ciudad>> lista = iCiudadRepository.findByRegion(iRegionRepository.findById(region_id)); 
		return lista;
	}

}
