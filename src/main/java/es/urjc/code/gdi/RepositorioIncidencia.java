package es.urjc.code.gdi;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="incidencias")
public interface RepositorioIncidencia extends JpaRepository <Incidencia, Long>{

	@CacheEvict(allEntries=true)
	Incidencia save(Incidencia incidencia);
	
	@Cacheable
	List <Incidencia> findByCliente(Usuario cliente);
	
	@Cacheable
	List <Incidencia> findAllByOrderByUrgenciaDesc();
}
