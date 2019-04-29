package es.urjc.code.gdi;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

//@CacheConfig(cacheNames="gdi")
public interface RepositorioCrudUsuario extends CrudRepository <Usuario, Long> {

	//@Cacheable
	Usuario findByNombre(String nombre);
}