package es.urjc.code.gdi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Incidencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idIncidencia;
	
	private LocalDateTime fecha;
	private String urgencia;
	private String categoria;
	private String estado;
	private String titulo;
	private String descripcion;
	private String solucion;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Comentario> comentarios = new ArrayList<>();
	
	@ManyToOne
	private Usuario asignatario;
	
	@ManyToOne
	private Usuario cliente;
		
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Incidencia () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param cliente Identifica al usuario que ha abierto la incidencia
	 * @param urgencia Describe la criticidad de la incidencia (alta, media o baja)
	 * @param categoria Área en la que se engloba el problema indicado en la incidencia (problema HW, Error SW ventas, Solicitud de nuevo correo electrónico, etc...)
	 * @param estado Describe la situación actual de la incidencia (abierta, solucionada, cerrada)
	 * @param titulo Asunto descriptivo del problema reportado en la incidencia
	 * @param descripcion Descripción detallada del problema que se necesita tratar
	 */
	public Incidencia (Usuario cliente, String urgencia, String categoria, String estado,String titulo, String descripcion) {
		
		super();
		setFecha();
		setCliente (cliente);
		setUrgencia(urgencia);
		setCategoria(categoria);
		setEstado(estado);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setSolucion("");
	}
	
	/**
	 * Método set para establecer el identificador de una incidencia
	 * 
	 * @param idIncidencia Identificador único para una Incidencia
	 */
	public void setIdIncidencia (Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	
	/**
	 * Método set para establecer la fecha de apertura de una Incidencia
	 * 
	 * @param fecha Fecha en la que se crea una Incidencia. En formato DD/MM/YYYY HH:SS
	 */
	public void setFecha () {
		this.fecha = LocalDateTime.now();
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
	 * Método set para añadir una lista de comentarios a una Incidencia
	 * 
	 * @param comentarios Lista de comentarios asociados a la Incidencia
	 */
	public void setComentarios (List <Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * Método set para establecer el asignatario de una Incidencia
	 * 
	 * @param asignatario Identificador del usuario que ha reconocido la incidencia para atenderla
	 */
	public void setAsignatario (Usuario asignatario) {
		this.asignatario = asignatario;
	}
	
	/**
	 * Método set para establecer el cliente de una Incidencia
	 * 
	 * @param asignatario Identificador del usuario que ha abierto la incidencia
	 */
	public void setCliente (Usuario cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Método get para devolver el identificador único una Incidencia
	 * 
	 * @return Devuelve el identificador único una Incidencia
	 */
	public Long getIdIncidencia () {
		return this.idIncidencia;
	}
	
	/**
	 * Método get para devolver la Fecha de creación de una Incidencia
	 * 
	 * @return Devuelve la fecha de una Incidencia
	 */
	public LocalDateTime getFecha () {
		return this.fecha;
	}
	
	/**
	 * Método get para devolver la urgencia de una Incidencia
	 * 
	 * @return Devuelve la urgencia de una Incidencia
	 */
	public String getUrgencia () {
		return this.urgencia;
	}
	
	/**
	 * Método get para devolver la categoría de una Incidencia
	 * 
	 * @return Devuelve la categoria de una Incidencia
	 */
	public String getCategoria () {
		return this.categoria;
	}
	
	/**
	 * Método get para devolver el estado de una Incidencia
	 * 
	 * @return Devuelve el estado de una Incidencia
	 */
	public String getEstado () {
		return this.estado;
	}
	
	/**
	 * Método get para devolver el título de una Incidencia
	 * 
	 * @return Devuelve el titulo de una Incidencia
	 */
	public String getTitulo () {
		return this.titulo;
	}
	
	/**
	 * Método get para devolver la descripción de una Incidencia
	 * 
	 * @return Devuelve la descripcion de una Incidencia
	 */
	public String getDescripcion () {
		return this.descripcion;
	}
	
	/**
	 * Método get para devolver la solución de una Incidencia
	 * 
	 * @return Devuelve la solucion de una Incidencia
	 */
	public String getSolucion () {
		return this.solucion;
	}
	
	/**
	 * Método get para devolver la lista de comentarios asociados a una Incidencia
	 * 
	 * @return Devuelve la lista de comentarios asociados a la Incidencia
	 */
	public List <Comentario> getComentarios () {
		return this.comentarios;
	}
	
	/**
	 * Método get para devolver el asignatario de una Incidencia
	 * 
	 * @return Devuelve el identificador del usuario que ha reconocido la incidencia para atenderla
	 */
	public Usuario setAsignatario () {
		return this.asignatario;
	}
	
	/**
	 * Método get para devolver el cliente de una Incidencia
	 * 
	 * @return Devuelve el identificador del usuario que ha abierto la incidencia
	 */
	public Usuario setCliente () {
		return this.cliente;
	}
	
	@Override
	public String toString () {
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