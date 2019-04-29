package es.urjc.code.gdi;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComentario;

	private LocalDateTime fecha;
	private String anotacion;
	
	@ManyToOne
	@JsonBackReference
	private Usuario autor;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Comentario () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param autor Identifica al usuario que realiza un comentario
	 * @param anotacion Contenido del Comentario
	 */
	public Comentario (Usuario autor, String anotacion) {
		
		super();
		setFecha ();
		setAutor (autor);
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
	 * Método set para guardar el autor del Comentario
	 * 
	 * @param autor Identifica al usuario que realiza un comentario
	 */
	public void setAutor (Usuario autor) {
		this.autor = autor;
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
	
	/**
	 * Método get para devolver el autor del Comentario
	 * 
	 * @return autor devuelve el usuario que ha realizado el comentario
	 */
	public Usuario getAutor () {
		return this.autor;
	}
	
	@Override
	public String toString() {
		return ("[COMENTARIO][" + getFecha() + "][" + autor.getNombre() + "]: " + getAnotacion());
	}
}