package es.urjc.code.gdi;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="gdi")
public interface RepositorioDepartamento extends JpaRepository <Departamento, Long> {

}