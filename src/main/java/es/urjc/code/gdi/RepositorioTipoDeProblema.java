package es.urjc.code.gdi;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="gdi")
public interface RepositorioTipoDeProblema extends JpaRepository <TipoDeProblema, Long> {
	
	@CacheEvict(allEntries=true)
	TipoDeProblema save(TipoDeProblema tipoDeProblema);
	
	//@Cacheable
	//List <TipoDeProblema> findAll();
}