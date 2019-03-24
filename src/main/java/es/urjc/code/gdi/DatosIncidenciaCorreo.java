package es.urjc.code.gdi;

public class DatosIncidenciaCorreo {

	private Long idIncidencia;
	private String titulo;
	private String descripcion;
	private String solucion;
	private String userEmail;
	
	public DatosIncidenciaCorreo () {}
	
	public DatosIncidenciaCorreo (Long idIncidencia, String titulo, String descripcion, String solucion, String userEmail) {
		setIdIncidencia (idIncidencia);
		setTitulo (titulo);
		setDescripcion (descripcion);
		setSolucion (solucion);
		setUserEmail (userEmail);
	}
	
	public void setIdIncidencia (Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setSolucion (String solucion) {
		this.solucion = solucion;
	}
	
	public void setUserEmail (String userEmail) {
		this.userEmail = userEmail;
	}
	
	public Long getIdIncidencia () {
		return this.idIncidencia;
	}
	
	public String getTitulo () {
		return this.titulo;
	}
	
	public String getDescripcion () {
		return this.descripcion;
	}
	
	public String getSolucion () {
		return this.solucion;
	}
	
	public String getUserEmail () {
		return this.userEmail;
	}
}
