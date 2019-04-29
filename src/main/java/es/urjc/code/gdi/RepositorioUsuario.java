package es.urjc.code.gdi;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="gdi")
public interface RepositorioUsuario extends JpaRepository <Usuario, Long>{

	@Cacheable
	Usuario findByNombre(String nombre);
	
	@CacheEvict(allEntries=true)
	Usuario save(Usuario usuario);
	
	@Cacheable
	List <Usuario> findAll();
}