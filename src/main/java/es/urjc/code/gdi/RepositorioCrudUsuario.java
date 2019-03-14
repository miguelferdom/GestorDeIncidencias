package es.urjc.code.gdi;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioCrudUsuario extends CrudRepository <Usuario, Long> {

	Usuario findByNombre(String nombre);
}
