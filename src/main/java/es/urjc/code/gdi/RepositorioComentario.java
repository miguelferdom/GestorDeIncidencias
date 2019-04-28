package es.urjc.code.gdi;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="comentarios")
public interface RepositorioComentario extends JpaRepository <Comentario, Long> {

	@CacheEvict(allEntries=true)
	Comentario save(Comentario comentario);

	@Cacheable
	List <Comentario> findAll();
}