package es.urjc.code.gdi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioIncidencia extends JpaRepository <Incidencia, Long>{

	Incidencia save(Incidencia incidencia);
	
	List <Incidencia> findByCliente(Usuario cliente);

	List <Incidencia> findAllByOrderByUrgenciaDesc();
}