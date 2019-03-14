package es.urjc.code.gdi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository <Usuario, Long>{

	Usuario findByNombre(String nombre);
}
