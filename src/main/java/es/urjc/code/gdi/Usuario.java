package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	private String nombre;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private List <String> perfiles = new ArrayList<>();
	
	@OneToMany(mappedBy="asignatario")
	private List <Incidencia> incidenciasAsignadas = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	private List <Incidencia> incidenciasAbiertas = new ArrayList<>();
	
	@OneToMany(mappedBy="autor")
	@Fetch(FetchMode.JOIN)
	private List <Comentario> comentariosRealizados = new ArrayList<>();
	
	private String email;
	
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
	public Usuario (String nombre, String password, String perfil, String email) {
		
		super();
		setNombre (nombre);
		setPassword(password);
		setPerfiles (perfil);
		setEmail(email);
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
	 * Método set para establecer la contraseña de un Usuario, se guardará encriptada
	 * 
	 * @param password Contraseña del usuario en la aplicacion
	 */
	public void setPassword (String password) {
		this.password = (new BCryptPasswordEncoder().encode(password));
	}

	/**
	 * Método set para establecer los perfiles de un Usuario
	 * 
	 * @param perfil Rol del usuario dentro de la aplicacion (usuario, técnico o administrador)
	 */
	public void setPerfiles (String perfil) {
		this.perfiles.add(perfil);
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
	 * Método set para establecer la lista de comentarios realizados por el usuario
	 * 
	 * @param comentariosRealizados Lista de comentarios realizados por el usuario
	 */
	public void setComentariosRealizados (List <Comentario> comentariosRealizados) {
		this.comentariosRealizados = comentariosRealizados;
	}
	
	/**
	 * Método set para establecer el correo electronico de un Usuario
	 * 
	 * @param email Correo electrónico del Usuario
	 */
	public void setEmail (String email) {
		this.email = email;
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
	 * @return Devuelve el password del usuario encriptada
	 */
	public String getPassword () {
		return this.password;
	}
	
	/**
	 * Método get para devolver la perfiles de un Usuario
	 * 
	 * @return Devuelve los perfiles del usuario
	 */
	public List <String> getPerfiles () {
		return this.perfiles;
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
	
	/**
	 * Método get para devolver la lista de comentarios realizados por el usuario
	 * 
	 * @param Devuelve la lista de comentarios realizados por el usuario
	 */
	public List <Comentario> getComentariosRealizados () {
		return this.comentariosRealizados;
	}
	
	/**
	 *  Método get para devolver el correo electronico de un Usuario
	 * 
	 * @return Devuelve el email de un usuario 
	 */
	public String getEmail () {
		return this.email;
	}
	
	@Override
	public String toString () {
		return("[USUARIO] Nombre: " + getNombre() + "; password: " + getPassword());
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
			Usuario aux = (Usuario) obj;
			if (this.getNombre().equals(aux.getNombre())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}