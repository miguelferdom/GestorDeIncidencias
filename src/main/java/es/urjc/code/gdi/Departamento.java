package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDepartamento;
	private String nombreDepartamento;
	private int criticidadDepartamento;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <TipoDeProblema> problemas = new ArrayList<>();
	
	@OneToMany(mappedBy="departamento")
	private List <Incidencia> incidenciasDepartamentos = new ArrayList<>();
	
	/**
	 * Constructor de la clase sin parámetros
	 */
	public Departamento () {}
	
	/**
	 * Constructor completo de la clase
	 * 
	 * @param nombreDepartamento Identifica el departamento con el que estaría relacionada la incidencia
	 * @param criticidadDepartamento Codifica la importancia del departamento dentro de la empresa, se usará para calcular como de importante es una incidencia
	 */
	public Departamento (String nombreDepartamento, int criticidadDepartamento) {
		
		super();
		setNombreDepartamento (nombreDepartamento);
		setCriticidadDepartamento(criticidadDepartamento);
	}
	
	/**
	 * Método set para establecer el identificador de un departamento
	 * 
	 * @param idDepartamento Identificador único para un departamento
	 */
	public void setIdDepartamento (Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	/**
	 * Método set para establecer el nombre de un departamento
	 * 
	 * @param nombreDepartamento Nombre de un departamento
	 */
	public void setNombreDepartamento (String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	
	/**
	 * Método set para establecer la criticidad de un departamento
	 * 
	 * @param criticidadDepartamento Codifica la importancia del departamento dentro de la empresa
	 */
	public void setCriticidadDepartamento (int criticidadDepartamento) {
		this.criticidadDepartamento = criticidadDepartamento;
	}
	
	/**
	 * Método set para añadir una lista de problemas a un departamento
	 * 
	 * @param comentarios Lista de problemas asociados a un departamento
	 */
	public void setProblemas (List <TipoDeProblema> problemas) {
		this.problemas = problemas;
	}
	
	/**
	 * Método set para establecer la lista de incidencias asociadas al departamento
	 * 
	 * @param incidenciasAsignadas Lista de incidencias asociadas al departamento
	 */
	public void setIncidenciasDepartamentos (List <Incidencia> incidenciasDepartamentos) {
		this.incidenciasDepartamentos = incidenciasDepartamentos;
	}
	
	/**
	 * Método get para devolver el identificador único un departamento
	 * 
	 * @return Devuelve el identificador único un departamento
	 */
	public Long getIdDepartamento () {
		return this.idDepartamento;
	}
	
	/**
	 * Método get para devolver el nombre un departamento
	 * 
	 * @return Nombre del departamento
	 */
	public String getNombreDepartamento () {
		return this.nombreDepartamento;
	}
	
	/**
	 * Método get para devolver la criticidad un departamento
	 * 
	 * @return Criticidad del departamento
	 */
	public int getCriticidadDepartamento () {
		return this.criticidadDepartamento;
	}
	
	/**
	 * Método get para devolver la lista de problemas asociados a un departamento
	 * 
	 * @return Devuelve la lista de problemas asociados a un departamento
	 */
	public List <TipoDeProblema> getProblemas () {
		return this.problemas;
	}
	
	/**
	 * Método get para devolver la lista de incidencias asociadas al departamento
	 * 
	 * @return incidenciasAsignadas Devuelve la lista de incidencias asociadas al departamento
	 */
	public List <Incidencia> getIncidenciasDepartamentos () {
		return this.incidenciasDepartamentos;
	}
	
	/**
	 * Método get para devolver la urgencia de un problema en funcion de la criticidad del departamento y el problema asociado a el
	 * 
	 * @return
	 */
	public int getUrgenciaProblemaDepartamento (String nombreProblema) {
		
		int criticidadProblema = 0;
		
		TipoDeProblema problema = new TipoDeProblema ();
		problema.setNombreProblema(nombreProblema);
		
		for (TipoDeProblema p : this.getProblemas()) {
			if (p.equals(problema)) {
				criticidadProblema = p.getCriticidadProblema();
			}
		}
		
		return (this.criticidadDepartamento * criticidadProblema);
	}
}
