package co.com.ingeneo.nicocine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ingeneo.nicocine.entity.Ciudad;
import co.com.ingeneo.nicocine.entity.Region;


@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long>{

	boolean existsByRegion(Optional<Region> region);

	Optional<List<Ciudad>> findByRegion(Optional<Region> region);

}
