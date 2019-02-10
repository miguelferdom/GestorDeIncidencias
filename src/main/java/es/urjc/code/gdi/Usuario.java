package es.urjc.code.gdi;

public class Usuario {

	private String nombre;
	private String password;
	private String perfil;
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Usuario () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param nombre Nombre del usuario en la aplicación
	 * @param password Contraseña del usuario en la aplicacion
	 * @param perfil Rol del usuario dentro de la aplicacion (usuario, técnico o administrador)
	 */
	public Usuario (String nombre, String password, String perfil) {
		setNombre (nombre);
		setPassword(password);
		setPerfil (perfil);
	}
	
	/**
	 * Método set para establecer el nombre de un Usuario
	 * 
	 * @param nombre Nombre del usuario en la aplicación
	 */
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método set para establecer la contraseña de un Usuario
	 * 
	 * @param password Contraseña del usuario en la aplicacion
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Método set para establecer el perfil de un Usuario
	 * 
	 * @param perfil Rol del usuario dentro de la aplicacion (usuario, técnico o administrador)
	 */
	public void setPerfil (String perfil) {
		this.perfil = perfil;
	}
	
	/**
	 * Método get para devolver el nombre de un Usuario
	 * 
	 * @return devuelve el nombre del usuario
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Método get para devolver el password de un Usuario
	 * 
	 * @return devuelve el password del usuario
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Método get para devolver el perfil de un Usuario
	 * 
	 * @return devuelve el perfil del usuario
	 */
	public String getPerfil() {
		return this.perfil;
	}
	
	@Override
	public String toString() {
		return("[USUARIO] Nombre: " + getNombre() + "; password: " + getPassword() + "; perfil: " + getPerfil());
	}
}