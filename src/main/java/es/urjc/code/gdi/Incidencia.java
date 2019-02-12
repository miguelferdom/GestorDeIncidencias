package es.urjc.code.gdi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Incidencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idIncidencia;
	
	/* 
	 * Declaro fecha como String para crear la clase rapidamente y poder hacer alguna prueba
	 * Más adelante la cambiaré a un tipo más adecuado junto con sus métodos get y set y el
	 * constructor completo
	 */
	private String fecha;
	private String urgencia;
	private String categoria;
	private String estado;
	private String titulo;
	private String descripcion;
	private String solucion;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Incidencia () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param idIncidencia identificador único para una Incidencia
	 * @param fecha Fecha en la que se crea una Incidencia. En formato DD/MM/YYYY HH:SS
	 * @param urgencia Describe la criticidad de la incidencia (alta, media o baja)
	 * @param categoria Área en la que se engloba el problema indicado en la incidencia (problema HW, Error SW ventas, Solicitud de nuevo correo electrónico, etc...)
	 * @param estado Describe la situación actual de la incidencia (abierta, solucionada, cerrada)
	 * @param titulo Asunto descriptivo del problema reportado en la incidencia
	 * @param descripcion Descripción detallada del problema que se necesita tratar
	 */
	public Incidencia (Long idIncidencia, String urgencia, String categoria, String estado,String titulo, String descripcion) {
		
		setIdIncidencia(idIncidencia);
		setFecha(fecha);
		setUrgencia(urgencia);
		setCategoria(categoria);
		setEstado(estado);
		setTitulo(titulo);
		setDescripcion(descripcion);
	}
	
	/**
	 * Método set para establecer el identificador de una incidencia
	 * 
	 * @param idIncidencia identificador único para una Incidencia
	 */
	public void setIdIncidencia (Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	
	/**
	 * Método set para establecer la fecha de apertura de una Incidencia
	 * 
	 * @param fecha Fecha en la que se crea una Incidencia. En formato DD/MM/YYYY HH:SS
	 */
	public void setFecha (String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Método set para establecer la urgencia de una Incidencia
	 * 
	 * @param urgencia Describe la criticidad de la incidencia (alta, media o baja)
	 */
	public void setUrgencia (String urgencia) {
		this.urgencia = urgencia;
	}
	
	/**
	 * Método set para establecer la categoria de una Incidencia
	 * 
	 * @param categoria Área en la que se engloba el problema indicado en la incidencia (problema HW, Error SW ventas, Solicitud de nuevo correo electrónico, etc...)
	 */
	public void setCategoria (String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Método set para establecer el estado de una Incidencia
	 * 
	 * @param estado Describe la situación actual de la incidencia (abierta, solucionada, cerrada)
	 */
	public void setEstado (String estado) {
		this.estado = estado;
	}
	
	/**
	 * Método set para establecer el titulo de una Incidencia
	 * 
	 * @param titulo Asunto descriptivo del problema reportado en la incidencia
	 */
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método set para establecer la descripcion de una Incidencia
	 * 
	 * @param descripcion Descripción detallada del problema que se necesita tratar
	 */
	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Método set para establecer la solucion de una Incidencia
	 * 
	 * @param solucion Descripción de las accciones realizadas para poder dar como solucionada la inciencia
	 */
	public void setSolucion (String solucion) {
		this.solucion = solucion;
	}
	
	/**
	 * Método get para devolver el identificador único una Incidencia
	 * 
	 * @return devuelve el identificador único una Incidencia
	 */
	public Long getIdIncidencia () {
		return this.idIncidencia;
	}
	
	/**
	 * Método get para devolver la Fecha de creación de una Incidencia
	 * 
	 * @return devuelve la fecha de una Incidencia
	 */
	public String getFecha () {
		return this.fecha;
	}
	
	/**
	 * Método get para devolver la urgencia de una Incidencia
	 * 
	 * @return devuelve la urgencia de una Incidencia
	 */
	public String getUrgencia () {
		return this.urgencia;
	}
	
	/**
	 * Método get para devolver la categoría de una Incidencia
	 * 
	 * @return devuelve la categoria de una Incidencia
	 */
	public String getCategoria () {
		return this.categoria;
	}
	
	/**
	 * Método get para devolver el estado de una Incidencia
	 * 
	 * @return devuelve el estado de una Incidencia
	 */
	public String getEstado () {
		return this.estado;
	}
	
	/**
	 * Método get para devolver el título de una Incidencia
	 * 
	 * @return devuelve el titulo de una Incidencia
	 */
	public String getTitulo () {
		return this.titulo;
	}
	
	/**
	 * Método get para devolver la descripción de una Incidencia
	 * 
	 * @return devuelve la descripcion de una Incidencia
	 */
	public String getDescripcion () {
		return this.descripcion;
	}
	
	/**
	 * Método get para devolver la solución de una Incidencia
	 * 
	 * @return devuelve la solucion de una Incidencia
	 */
	public String getSolucion () {
		return this.solucion;
	}
	
	@Override
	public String toString() {
		return ("[INCIDENCIA] idIncidencia: " + getIdIncidencia() + "\n" +
				"[INCIDENCIA] Fecha: " + getFecha() + "\n" +
				"[INCIDENCIA] Urgencia: " + getUrgencia() + "\n" +
				"[INCIDENCIA] Categoria: " + getCategoria() + "\n" +
				"[INCIDENCIA] Estado: " + getEstado() + "\n" +
				"[INCIDENCIA] Título: " + getTitulo() + "\n" +
				"[INCIDENCIA] Descripción: " + getDescripcion() + "\n" +
				"[INCIDENCIA] Solución: " + getSolucion());
	}
}