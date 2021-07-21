package co.com.ingeneo.nicocine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ingeneo.nicocine.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nu);
    boolean existsByNombre(String nu);
    boolean existsByNombreAndPassword(String nombre, String Password);
}