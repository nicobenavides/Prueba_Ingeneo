package co.com.ingeneo.nicocine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ingeneo.nicocine.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{

}
