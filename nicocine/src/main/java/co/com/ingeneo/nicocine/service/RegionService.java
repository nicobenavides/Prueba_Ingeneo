package co.com.ingeneo.nicocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ingeneo.nicocine.entity.Region;
import co.com.ingeneo.nicocine.repository.IRegionRepository;

@Service
public class RegionService {

	@Autowired
	IRegionRepository iRegionRepository;

	public List<Region> obtenerTodos() {
		List<Region> lista = iRegionRepository.findAll();
		return lista;
	}

	public void guardar(Region region) {
		iRegionRepository.save(region);
	}

	public void actualizar(List<Region> region) {
		for(Region c: region) {
			Region c2 = iRegionRepository.getById(c.getId());
			iRegionRepository.save(c2);
		}
	}

}
