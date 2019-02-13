package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	private String nombre;
	private String password;
	private String perfil;
	
	@OneToMany(mappedBy="asignatario")
	private List <Incidencia> incidenciasAsignadas = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	private List <Incidencia> incidenciasAbiertas = new ArrayList<>();
		
	
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
		
		super();
		setNombre (nombre);
		setPassword(password);
		setPerfil (perfil);
	}
	
	/**
	 * Método set para establecer el identificador de un usuario
	 * 
	 * @param idIncidencia identificador único para un Usuario
	 */
	public void setIdUsuario (Long idUsuario) {
		this.idUsuario = idUsuario;
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
	public void setPassword (String password) {
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
	 * Método set para establecer la lista de incidencias atendidas por el usuario
	 * 
	 * @param incidenciasAsignadas Lista de incidencias atendidas por el usuario
	 */
	public void setIncidenciasAsignadas (List <Incidencia> incidenciasAsignadas) {
		this.incidenciasAsignadas = incidenciasAsignadas;
	}
	
	/**
	 * Método set para establecer la lista de incidencias abiertas por el usuario
	 * 
	 * @param incidenciasAsignadas Lista de incidencias abiertas por el usuario
	 */
	public void setIncidenciasAbiertas (List <Incidencia> incidenciasAbiertas) {
		this.incidenciasAbiertas = incidenciasAbiertas;
	}
	
	/**
	 * Método get para devolver el identificador único un Usuario
	 * 
	 * @return Devuelve el identificador único un Usuario
	 */
	public Long getIdUsuario () {
		return this.idUsuario;
	}
	
	/**
	 * Método get para devolver el nombre de un Usuario
	 * 
	 * @return Devuelve el nombre del usuario
	 */
	public String getNombre () {
		return this.nombre;
	}
	
	/**
	 * Método get para devolver el password de un Usuario
	 * 
	 * @return Devuelve el password del usuario
	 */
	public String getPassword () {
		return this.password;
	}
	
	/**
	 * Método get para devolver el perfil de un Usuario
	 * 
	 * @return Devuelve el perfil del usuario
	 */
	public String getPerfil () {
		return this.perfil;
	}
	
	/**
	 * Método get para devolver la lista de incidencias atendidas por el usuario
	 * 
	 * @return Devuelve la lista de incidencias atendidas por el usuario
	 */
	public List <Incidencia> setIncidenciasAsignadas () {
		return this.incidenciasAsignadas;
	}
	
	/**
	 * Método get para devolver la lista de incidencias abiertas por el usuario
	 * 
	 * @return Devuelve la lista de incidencias abiertas por el usuario
	 */
	public List <Incidencia> setIncidenciasAbiertas () {
		return this.incidenciasAbiertas;
	}
	
	@Override
	public String toString () {
		return("[USUARIO] Nombre: " + getNombre() + "; password: " + getPassword() + "; perfil: " + getPerfil());
	}
}