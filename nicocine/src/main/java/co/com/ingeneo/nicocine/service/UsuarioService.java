package co.com.ingeneo.nicocine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ingeneo.nicocine.entity.Usuario;
import co.com.ingeneo.nicocine.repository.IUsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nu){
        return iUsuarioRepository.findByNombre(nu);
    }

    
    public void guardar(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }


	public Boolean validar(Usuario loginUsuario) {		
		return iUsuarioRepository.existsByNombreAndPassword(loginUsuario.getNombre(), loginUsuario.getPassword());
	}
    
    
}