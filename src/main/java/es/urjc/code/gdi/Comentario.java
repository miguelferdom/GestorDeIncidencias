package es.urjc.code.gdi;

public class Comentario {

	/* 
	 * Declaro fecha como String para crear la clase rapidamente y poder hacer alguna prueba
	 * Más adelante la cambiaré a un tipo más adecuado junto con sus métodos get y set y el
	 * constructor completo
	 */
	private String fecha;
	private String anotacion;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Comentario () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param fecha fecha en la que se anota un Comentario en formato DD/MM/YYYY HH:SS
	 * @param anotacion contenido del Comentario
	 */
	public Comentario (String fecha, String anotacion) {
		setFecha (fecha);
		setAnotacion ( anotacion);
	}
	
	/**
	 * Método set para establecer la fecha de un Comentario
	 * 
	 * @param fecha fecha en la que se anota un comentario en formato DD/MM/YYYY HH:SS
	 */
	public void setFecha (String fecha) {
		this.fecha = fecha;
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
	public String getFecha () {
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