package es.urjc.code.gdi;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

@CacheConfig(cacheNames="gdi")
public interface RepositorioCrudUsuario extends CrudRepository <Usuario, Long> {

	@CacheEvict(allEntries=true)
	Usuario save(Usuario usuario);
	
	@Cacheable
	Usuario findByNombre(String nombre);
	
	@Cacheable
	List <Usuario> findAll();
}