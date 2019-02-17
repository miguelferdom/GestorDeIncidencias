package es.urjc.code.gdi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoDeProblema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProblema;
	private String nombreProblema;
	private int criticidadProblema;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public TipoDeProblema () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param nombreProblema Nombre descriptivo de un problema
	 * @param criticidadProblema Codifica la importancia de un problema, se usará para calcular como de importante es una incidencia
	 */
	public TipoDeProblema (String nombreProblema, int criticidadProblema) {
		
		super();
		setNombreProblema (nombreProblema);
		setCriticidadProblema (criticidadProblema);
	}
	
	/**
	 * Método set para establecer el identificador de un problema
	 * 
	 * @param idProblema Identificador único para un problema
	 */
	public void setIdProblema (Long idProblema) {
		this.idProblema = idProblema;
	}
	
	/**
	 * Método set para establecer el nombre de un problema
	 * 
	 * @param nombreProblema Nombre descriptivo de un problema
	 */
	public void setNombreProblema(String nombreProblema) {
		this.nombreProblema = nombreProblema;
	}

	/**
	 * Método set para establecer la criticidad de un problema
	 * 
	 * @param criticidadProblema Codifica la importancia de un problema
	 */
	public void setCriticidadProblema (int criticidadProblema) {
		this.criticidadProblema = criticidadProblema;
	}
	
	/**
	 * Método get para devolver el identificador único un problema
	 * 
	 * @return Devuelve el identificador único un problema
	 */
	public Long getIdProblema () {
		return this.idProblema;
	}
	
	/**
	 * Método get para devolver el nombre un problema
	 * 
	 * @return Nombre descriptivo del problema
	 */
	public String getNombreProblema() {
		return this.nombreProblema;
	}

	/**
	 * Método get para devolver la criticidad un problema
	 * 
	 * @return Criticidad del problema
	 */
	public int getCriticidadProblema () {
		return this.criticidadProblema;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		else
		{
			TipoDeProblema aux = (TipoDeProblema) obj;
			if (this.getNombreProblema().equals(aux.getNombreProblema())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
