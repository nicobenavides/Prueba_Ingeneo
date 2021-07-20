package co.com.ingeneo.nicocine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ingeneo.nicocine.entity.Sucursal;
import co.com.ingeneo.nicocine.repository.ISucursalRepository;

@Service
public class SucursalService {

	

	
	@Autowired
	ISucursalRepository iSucursalRepository;

	public List<Sucursal> obtenerTodos() {
		List<Sucursal> lista = iSucursalRepository.findAll();
		return lista;
	}

	public void guardar(Sucursal sucursal) {
		iSucursalRepository.save(sucursal);
		
	}

	public void actualizar(List<Sucursal> sucursal) {
		for(Sucursal s: sucursal) {
			Sucursal s2 = iSucursalRepository.getById(s.getId());
			iSucursalRepository.save(s2);
		}
		
	}

}
