package es.urjc.code.gdi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategoria;
	
	private String departamento;
	private String tipo;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Categoria () {}
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Categoria (String departamento, String tipo) {
		
		super();
		setDepartamento (departamento);
		setTipo (tipo);
	}
	
	public void setDepartamento (String departamento) {
		this.departamento = departamento;
	}
	
	public void setTipo (String tipo) {
		this.tipo = tipo;
	}
	
	public String getDepartamento () {
		return this.departamento;
	}
	
	public String getTipo () {
		return this.tipo;
	}
}
