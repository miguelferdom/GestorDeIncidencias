package es.urjc.code.gdi;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComentario;

	private LocalDateTime fecha;
	private String anotacion;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Comentario () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param anotacion contenido del Comentario
	 */
	public Comentario (String anotacion) {
		
		super();
		setFecha ();
		setAnotacion (anotacion);
	}
	
	/**
	 * Método set para establecer la fecha de un Comentario en formato DD/MM/YYYY HH:SS
	 */
	public void setFecha () {
		this.fecha = LocalDateTime.now();
	}
	
	/**
	 * Método set para escribir el texto del Comentario
	 * 
	 * @param anotacion contenido del comentario
	 */
	public void setAnotacion (String anotacion) {
		this.anotacion = anotacion;
	}
	
	/**
	 * Método get para devolver la Fecha de un Comentario
	 * 
	 * @return devuelve la Fecha de un Comentario
	 */
	public LocalDateTime getFecha () {
		return this.fecha;
	}
	
	/**
	 * Método get para devolver el texto de un Comentario
	 * 
	 * @return devuelve el texto de un Comentario
	 */
	public String getAnotacion () {
		return this.anotacion;
	}
	
	@Override
	public String toString() {
		return ("[COMENTARIO][" + getFecha() + "]: " + getAnotacion());
	}
}