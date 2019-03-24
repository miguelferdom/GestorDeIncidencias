package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.Authentication;

@Controller
public class GdiControllers {
	
	@Autowired
	private RepositorioIncidencia repoIncidencias;

	@Autowired
	private RepositorioUsuario repoUsuarios;
	
	@Autowired
	private RepositorioComentario repoComentarios;
	
	@Autowired
	private RepositorioDepartamento repoDepartamentos;
	
	@Autowired
	private RepositorioTipoDeProblema repoTipoDeProblemas;
	
	private List<Incidencia> incidencias;

	private Usuario obtenerUsuario (String nbUsuario) {
		
		Usuario userAux = new Usuario();
		userAux.setNombre(nbUsuario);
		
		Long idUser = 0L;
		
		for (Usuario u : repoUsuarios.findAll()) {
			if (u.equals(userAux)) {
				idUser = u.getIdUsuario();
			}
		}
		
		userAux = repoUsuarios.getOne(idUser);
		
		return userAux;
	}
	
	private Departamento obtenerDepartamento (String nbDepartamento) {
		
		Departamento dptoAux = new Departamento ();
		dptoAux.setNombreDepartamento(nbDepartamento);
		
		Long idDpto = 0L;
		
		for (Departamento d : repoDepartamentos.findAll()) {
			if (d.equals(dptoAux)) {
				idDpto = d.getIdDepartamento();
			}
		}
		
		dptoAux = repoDepartamentos.getOne(idDpto);
		
		return dptoAux;
	}
	
	private void CargarDatosSesionHttpEnModelo (Model model, HttpServletRequest request) {
		
		model.addAttribute("esUsuario", request.isUserInRole("usuario"));
		model.addAttribute("esTecnico", request.isUserInRole("tecnico"));
		model.addAttribute("esAdministrador", request.isUserInRole("administrador"));
		model.addAttribute("nbUsuario", request.getRemoteUser());
		
		Usuario user = obtenerUsuario(request.getRemoteUser());
		
		// si el usuario logado tiene un rol de tecnico o superior, mostramos todas las incidencias
		if (request.isUserInRole("tecnico")) {
			model.addAttribute("incidencias", repoIncidencias.findAllByOrderByUrgenciaDesc());
			//System.out.println("[CargarDatosSesionHttpEnModelo]: cargado el modelo todas indidencias");
		}
		// si no solo ve en las que aparece como cliente
		else {
			model.addAttribute("incidencias", repoIncidencias.findByCliente(user));
			//System.out.println("[CargarDatosSesionHttpEnModelo]: cargado el modelo indidencias del cliente");
		}
	}
	
	private void EstadosIncidencia (Model model, HttpServletRequest request, Incidencia incidencia) {
		
		boolean estaAsignada;
		if (incidencia.getAsignatario()!=null) {
			estaAsignada = true;
		}
		else {
			estaAsignada = false;
		}
		model.addAttribute("estaAsignada", estaAsignada);
				
		boolean tieneSolucion;
		if (incidencia.getSolucion().equals("")) {
			tieneSolucion = false;
		}
		else {
			tieneSolucion = true;
		}		
		model.addAttribute("tieneSolucion", tieneSolucion);
		
		boolean estaCerrada;
		if (incidencia.getEstado().equals("Cerrada")) {
			estaCerrada = true;
		}
		else {
			estaCerrada = false;
		}
		model.addAttribute("estaCerrada", estaCerrada);
		
		boolean usuarioEsElcliente;
		if (incidencia.getCliente().getNombre().equals(request.getRemoteUser())) {
			usuarioEsElcliente = true;
		}
		else {
			usuarioEsElcliente = false;
		}
		model.addAttribute("usuarioEsElcliente", usuarioEsElcliente);
	}
	
	@PostConstruct
	public void init() {
		
		Departamento dpto1 = new Departamento ("Correo", 2);
		Departamento dpto2 = new Departamento ("Ventas", 7);
		Departamento dpto3 = new Departamento ("Microinformatica", 2);
		Departamento dpto4 = new Departamento ("RRHH", 5);
		Departamento dpto5 = new Departamento ("Sistemas", 8);
		Departamento dpto6 = new Departamento ("BBDD", 8);
		Departamento dpto7 = new Departamento ("Comunicaciones", 8);
		
		
		dpto1.getProblemas().add(new TipoDeProblema("Alta de correo", 5));
		dpto1.getProblemas().add(new TipoDeProblema("Baja de correo", 5));
		dpto1.getProblemas().add(new TipoDeProblema("Recuperacion de correos", 7));
		dpto1.getProblemas().add(new TipoDeProblema("Recepcion de correo malicioso", 10));
		dpto1.getProblemas().add(new TipoDeProblema("Recepcion Spam", 6));
		dpto1.getProblemas().add(new TipoDeProblema("Problema al enviar correos", 9));
		dpto1.getProblemas().add(new TipoDeProblema("Problema al recibir correos", 9));
		repoDepartamentos.save(dpto1);
		dpto2.getProblemas().add(new TipoDeProblema("SW ventas no funciona", 10));
		dpto2.getProblemas().add(new TipoDeProblema("SW ventas funciona muy lento", 6));
		dpto2.getProblemas().add(new TipoDeProblema("SW Ventas no guarda datos", 7));
		dpto2.getProblemas().add(new TipoDeProblema("SW Ventas no recupera datos", 7));
		dpto2.getProblemas().add(new TipoDeProblema("Recuperacion de archivos historicos", 2));
		repoDepartamentos.save(dpto2);
		dpto3.getProblemas().add(new TipoDeProblema("No funciona la pantalla", 3));
		dpto3.getProblemas().add(new TipoDeProblema("No funciona el raton", 3));
		dpto3.getProblemas().add(new TipoDeProblema("No funciona el teclado", 3));
		dpto3.getProblemas().add(new TipoDeProblema("Entrega de PC", 7));
		dpto3.getProblemas().add(new TipoDeProblema("Retirada de PC", 4));
		dpto3.getProblemas().add(new TipoDeProblema("Instalacion de SW ofimatico", 7));
		dpto3.getProblemas().add(new TipoDeProblema("Revision de configuracion de SW", 7));
		repoDepartamentos.save(dpto3);
		dpto4.getProblemas().add(new TipoDeProblema("Alta empleado", 7));
		dpto4.getProblemas().add(new TipoDeProblema("Baja empleado", 7));
		dpto4.getProblemas().add(new TipoDeProblema("SW RRHH no funciona", 9));
		dpto4.getProblemas().add(new TipoDeProblema("SW RRHH funciona muy lento", 7));
		repoDepartamentos.save(dpto4);
		dpto5.getProblemas().add(new TipoDeProblema("Ampliacion espacio de disco", 5));
		dpto5.getProblemas().add(new TipoDeProblema("Llenado de disco", 8));
		dpto5.getProblemas().add(new TipoDeProblema("Caida de servidor", 10));
		dpto5.getProblemas().add(new TipoDeProblema("Caida de proceso", 9));
		dpto5.getProblemas().add(new TipoDeProblema("Antivirus", 5));
		dpto5.getProblemas().add(new TipoDeProblema("Ampliacion recursos de servidor", 6));
		dpto5.getProblemas().add(new TipoDeProblema("Retirada de servidor", 4));
		repoDepartamentos.save(dpto5);
		dpto6.getProblemas().add(new TipoDeProblema("Caida BD", 10));
		dpto6.getProblemas().add(new TipoDeProblema("Caida Listener", 8));
		dpto6.getProblemas().add(new TipoDeProblema("Llenado de archivers", 7));
		dpto6.getProblemas().add(new TipoDeProblema("Lentitud en consultas", 7));
		repoDepartamentos.save(dpto6);
		dpto7.getProblemas().add(new TipoDeProblema("Caida de red", 10));
		dpto7.getProblemas().add(new TipoDeProblema("Lentitud en red", 8));
		dpto7.getProblemas().add(new TipoDeProblema("Error en llamadas entrantes", 7));
		dpto7.getProblemas().add(new TipoDeProblema("Error en llamadas salientes", 7));
		dpto7.getProblemas().add(new TipoDeProblema("Linea de datos principal caida", 8));
		dpto7.getProblemas().add(new TipoDeProblema("Linea de datos backup caida", 6));
		repoDepartamentos.save(dpto7);
		
		Usuario user1 = new Usuario("user1", "user1", "ROLE_usuario", "m.fernandezdo@alumnos.urjc.es");
		Usuario user2 = new Usuario("user2", "user2", "ROLE_usuario", "m.fernandezdo@alumnos.urjc.es");
		Usuario user3 = new Usuario("user3", "user3", "ROLE_usuario", "m.fernandezdo@alumnos.urjc.es");
		Usuario user4 = new Usuario("user4", "user4", "ROLE_usuario", "m.fernandezdo@alumnos.urjc.es");
		
		Usuario tecn1 = new Usuario("tecn1", "tecn1", "ROLE_tecnico", "m.fernandezdo@alumnos.urjc.es");
		Usuario tecn2 = new Usuario("tecn2", "tecn2", "ROLE_tecnico", "m.fernandezdo@alumnos.urjc.es");
		Usuario tecn3 = new Usuario("tecn3", "tecn3", "ROLE_tecnico", "m.fernandezdo@alumnos.urjc.es");
		Usuario tecn4 = new Usuario("tecn4", "tecn4", "ROLE_tecnico", "m.fernandezdo@alumnos.urjc.es");
		tecn1.setPerfiles("ROLE_usuario");
		tecn2.setPerfiles("ROLE_usuario");
		tecn3.setPerfiles("ROLE_usuario");
		tecn4.setPerfiles("ROLE_usuario");
		
		Usuario admi1 = new Usuario("admi1", "admi1", "ROLE_administrador", "m.fernandezdo@alumnos.urjc.es");
		Usuario admi2 = new Usuario("admi2", "admi2", "ROLE_administrador", "m.fernandezdo@alumnos.urjc.es");
		Usuario admi3 = new Usuario("admi3", "admi3", "ROLE_administrador", "m.fernandezdo@alumnos.urjc.es");
		Usuario admi4 = new Usuario("admi4", "admi4", "ROLE_administrador", "m.fernandezdo@alumnos.urjc.es");
		admi1.setPerfiles("ROLE_usuario");
		admi2.setPerfiles("ROLE_usuario");
		admi3.setPerfiles("ROLE_usuario");
		admi4.setPerfiles("ROLE_usuario");
		admi1.setPerfiles("ROLE_tecnico");
		admi2.setPerfiles("ROLE_tecnico");
		admi3.setPerfiles("ROLE_tecnico");
		admi4.setPerfiles("ROLE_tecnico");
		
		repoUsuarios.save(user1);
		repoUsuarios.save(user2);
		repoUsuarios.save(user3);
		repoUsuarios.save(user4);
		repoUsuarios.save(tecn1);
		repoUsuarios.save(tecn2);
		repoUsuarios.save(tecn3);
		repoUsuarios.save(tecn4);
		repoUsuarios.save(admi1);
		repoUsuarios.save(admi2);
		repoUsuarios.save(admi3);
		repoUsuarios.save(admi4);
		
		Incidencia inc1 = new Incidencia(user1, dpto1, "Alta de correo", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99");
		inc1.setAsignatario(tecn2);
		inc1.setEstado("Aceptada");
		Incidencia inc2 = new Incidencia(user1, dpto1, "Baja de correo", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa");
		Incidencia inc3 = new Incidencia(user2, dpto2, "SW Ventas no recupera datos", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del almacén");
		Incidencia inc4 = new Incidencia(user3, dpto4, "Baja empleado", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla");
		inc4.setAsignatario(tecn1);
		inc4.setEstado("Aceptada");
		Incidencia inc5 = new Incidencia(user4, dpto3, "Entrega de PC", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas");
		Incidencia inc6 = new Incidencia(tecn1, dpto5, "Caida de servidor", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar");
		inc6.setAsignatario(admi2);
		inc6.setEstado("Aceptada");
		Incidencia inc7 = new Incidencia(tecn2, dpto5, "Antivirus", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus");
		Incidencia inc8 = new Incidencia(admi3, dpto1, "Alta de correo", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento.");	
		
		inc1.getComentarios().add(new Comentario(tecn2, "comentario 01"));
		inc1.getComentarios().add(new Comentario(tecn2, "comentario 02"));
		inc1.getComentarios().add(new Comentario(user1, "comentario 03"));
		inc1.getComentarios().add(new Comentario(tecn3, "comentario 04"));
		inc1.getComentarios().add(new Comentario(tecn2, "comentario 05"));
		repoIncidencias.save(inc1);
		inc2.getComentarios().add(new Comentario(user1, "comentario 06"));
		inc2.getComentarios().add(new Comentario(user1, "comentario 07"));
		inc2.getComentarios().add(new Comentario(user1, "comentario 08"));
		inc2.getComentarios().add(new Comentario(user1, "comentario 09"));
		inc2.getComentarios().add(new Comentario(user1, "comentario 10"));
		repoIncidencias.save(inc2);
		inc3.getComentarios().add(new Comentario(user2, "comentario 11"));
		inc3.getComentarios().add(new Comentario(user2, "comentario 12"));
		inc3.getComentarios().add(new Comentario(user2, "comentario 13"));
		inc3.getComentarios().add(new Comentario(user2, "comentario 14"));
		inc3.getComentarios().add(new Comentario(user2, "comentario 15"));
		repoIncidencias.save(inc3);
		inc4.getComentarios().add(new Comentario(tecn1, "comentario 16"));
		inc4.getComentarios().add(new Comentario(user3, "comentario 17"));
		inc4.getComentarios().add(new Comentario(tecn1, "comentario 18"));
		inc4.getComentarios().add(new Comentario(user3, "comentario 19"));
		inc4.getComentarios().add(new Comentario(tecn1, "comentario 20"));
		repoIncidencias.save(inc4);
		inc5.getComentarios().add(new Comentario(user4, "comentario 21"));
		inc5.getComentarios().add(new Comentario(user4, "comentario 22"));
		inc5.getComentarios().add(new Comentario(user4, "comentario 23"));
		inc5.getComentarios().add(new Comentario(user4, "comentario 24"));
		inc5.getComentarios().add(new Comentario(user4, "comentario 25"));
		repoIncidencias.save(inc5);
		inc6.getComentarios().add(new Comentario(tecn1, "comentario 26"));
		inc6.getComentarios().add(new Comentario(admi2, "comentario 27"));
		inc6.getComentarios().add(new Comentario(admi2, "comentario 28"));
		inc6.getComentarios().add(new Comentario(admi2, "comentario 29"));
		inc6.getComentarios().add(new Comentario(tecn1, "comentario 30"));
		repoIncidencias.save(inc6);
		inc7.getComentarios().add(new Comentario(tecn2, "comentario 31"));
		inc7.getComentarios().add(new Comentario(tecn2, "comentario 32"));
		inc7.getComentarios().add(new Comentario(tecn2, "comentario 33"));
		inc7.getComentarios().add(new Comentario(tecn2, "comentario 34"));
		inc7.getComentarios().add(new Comentario(tecn2, "comentario 35"));
		repoIncidencias.save(inc7);
		inc8.getComentarios().add(new Comentario(admi3, "comentario 36"));
		inc8.getComentarios().add(new Comentario(admi3, "comentario 37"));
		inc8.getComentarios().add(new Comentario(admi3, "comentario 38"));
		inc8.getComentarios().add(new Comentario(admi3, "comentario 39"));
		inc8.getComentarios().add(new Comentario(admi3, "comentario 40"));
		repoIncidencias.save(inc8);
		
		incidencias = repoIncidencias.findAll();
	}
	
	@GetMapping("/login")
	public String cargaLogin(Model model) {
		
		return "login.html";
	}
	
	@GetMapping("/loginerror")
	public String cargaLoginError(Model model) {
			
		return "loginerror.html";
	}

	@GetMapping("/logout")
	public String cargaLogout(Model model) {
			
		return "logout.html";
	}
	
	@GetMapping("/bienvenida")
	public String cargaBienvenida(Model model, HttpServletRequest request) {

		CargarDatosSesionHttpEnModelo (model, request);
		
		return "portal";
	}
	
	@RequestMapping("/nuevaincidencia")
	public String cargaNuevaIncidencia(Model model, HttpServletRequest request) {
		
		CargarDatosSesionHttpEnModelo (model, request);
		
		return "nuevaincidencia";
	}
	
	@GetMapping("/consultarincidencia")
	public String cargaConsultarIncidencia(Model model, HttpServletRequest request, @RequestParam Long numincidencia) {
		
		CargarDatosSesionHttpEnModelo (model, request);
		
		Incidencia incidencia = repoIncidencias.findById(numincidencia).orElseThrow(()-> new EntityNotFoundException("[cargaConsultarIncidencia] Incidencia " + numincidencia + " no encontrada"));
		model.addAttribute("incidencia", incidencia);
		
		EstadosIncidencia(model, request, incidencia);
		
		return "consultarincidencia";
	}
	
	@GetMapping("/consultarcomentario")
	public String cargaConsultarComentario(Model model, @RequestParam Long numcomentario, @RequestParam Long numincidencia) {
		
		Comentario comentario = repoComentarios.findById(numcomentario).orElseThrow(()-> new EntityNotFoundException("[cargaConsultarComentario] Comentario " + numcomentario + " no encontrado"));
		model.addAttribute("comentario", comentario);
		
		Incidencia incidencia = repoIncidencias.findById(numincidencia).orElseThrow(()-> new EntityNotFoundException("[cargaConsultarComentario] Incidencia " + numincidencia + " no encontrada"));
		model.addAttribute("incidencia", incidencia);
		
		
		return "consultarcomentario";
	}
	
	@RequestMapping("/volveraportal")
	public String volverAPortal (Model model, HttpServletRequest request) {
		
		CargarDatosSesionHttpEnModelo (model, request);
		
		return "portal";
	}
	
	@PostMapping("/crearincidencia")
	public String crearIncidencia (Model model, HttpServletRequest request, @RequestParam String departamento, @RequestParam String problema, @RequestParam String titulo, @RequestParam String descripcion) {	

		Usuario userCliente = obtenerUsuario(request.getRemoteUser());
		Departamento dpto = obtenerDepartamento(departamento);
				
		repoIncidencias.save(new Incidencia(userCliente, dpto, problema, titulo, descripcion));
		
		CargarDatosSesionHttpEnModelo (model, request);
		
		return "portal";
	}
	
	@PostMapping("/aceptarincidencia")
	public String aceptarincidencia (Model model, HttpServletRequest request, @RequestParam Long idIncidencia, @RequestParam String asignatario) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[aceptarincidencia] Incidencia " + idIncidencia + " no encontrada"));
		
		Usuario userAsignatario = obtenerUsuario(asignatario);
		
		incidencia.setAsignatario(userAsignatario);
		incidencia.setEstado("Aceptada");
		
		repoIncidencias.save(incidencia);
		model.addAttribute("incidencia", incidencia);
		
		CargarDatosSesionHttpEnModelo (model, request);
		EstadosIncidencia (model, request, incidencia);
		
		return "consultarincidencia";
	}
	
	@PostMapping("/guardarcomentario")
	public String guardarComentario (Model model, HttpServletRequest request, @RequestParam Long idIncidencia, @RequestParam String autor, @RequestParam String comentario) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[guardarComentario] Incidencia " + idIncidencia + " no encontrada"));
		
		Usuario userAutor = obtenerUsuario(autor);
		
		incidencia.getComentarios().add(new Comentario (userAutor, comentario));
		
		repoIncidencias.save(incidencia);
		model.addAttribute("incidencia", incidencia);
		
		CargarDatosSesionHttpEnModelo (model, request);
		EstadosIncidencia (model, request, incidencia);
		
		return "consultarincidencia";
	}
	
	@PostMapping("/guardarsolucion")
	public String guardarSolucion (Model model, HttpServletRequest request, @RequestParam Long idIncidencia, @RequestParam String autor, @RequestParam String solucion) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[guardarSolucion] Incidencia " + idIncidencia + " no encontrada"));
		
		Usuario userAutor = obtenerUsuario(autor);
		
		incidencia.getComentarios().add(new Comentario (userAutor, solucion));
		incidencia.setSolucion(solucion);
		incidencia.setEstado("Solucionada");
		
		repoIncidencias.save(incidencia);
		model.addAttribute("incidencia", incidencia);
		
		CargarDatosSesionHttpEnModelo (model, request);
		EstadosIncidencia (model, request, incidencia);
		
		// comunicacion con el servicio interno
		
		DatosIncidenciaCorreo datos = new DatosIncidenciaCorreo (incidencia.getIdIncidencia(), incidencia.getTitulo(), incidencia.getDescripcion(), incidencia.getSolucion(), incidencia.getCliente().getEmail());
		
		//direccion del servicio interno para pruebas en la máquina local
		//String url= "http://localhost:8080/mailer/";
		
		//direccion del servicio interno para pruebas en la máquina virtual
		String url= "http://192.168.1.7:8080/mailer/";
		
		RestTemplate msjRest = new RestTemplate();
		msjRest.postForObject(url, datos, DatosIncidenciaCorreo.class);
		
		return "consultarincidencia";
	}
	
	@PostMapping("/guardartitulodescripcion")
	public String guardarTituloDescripcion (Model model, HttpServletRequest request, @RequestParam Long idIncidencia, @RequestParam String titulo, @RequestParam String descripcion) {
		
		CargarDatosSesionHttpEnModelo (model, request);
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[guardarSolucion] Incidencia " + idIncidencia + " no encontrada"));
		
		incidencia.setTitulo(titulo);
		incidencia.setDescripcion(descripcion);
		
		repoIncidencias.save(incidencia);

		EstadosIncidencia(model, request, incidencia);
		
		model.addAttribute("incidencia", incidencia);

		return "consultarincidencia";
	}
	
	@PostMapping("/modificarcomentario")
	public String modificarComentario (Model model, @RequestParam Long idComentario, @RequestParam Long idIncidencia, @RequestParam String anotacion) {
		
		Comentario comentario = repoComentarios.findById(idComentario).orElseThrow(()-> new EntityNotFoundException("[modificarComentario] Comentario " + idComentario + " no encontrado")); 
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[modificarComentario] Incidencia " + idIncidencia + " no encontrada"));
		
		if (anotacion.equals("")) {
			
			if (incidencia.getSolucion().equals(comentario.getAnotacion())) {
				incidencia.setSolucion("");
				incidencia.setEstado("Aceptada");
			}
		}

			
		if (incidencia.getSolucion().equals(comentario.getAnotacion())) {
			incidencia.setSolucion(anotacion);
		}
		
		comentario.setAnotacion(anotacion);
		repoComentarios.save(comentario);
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		return "portal";
	}
	
	@PostMapping("/borrarcomentario")
	public String borrarComentario (Model model, @RequestParam Long idComentario, @RequestParam Long idIncidencia) {
		
		Comentario comentario = repoComentarios.findById(idComentario).orElseThrow(()-> new EntityNotFoundException("[borrarComentario] Comentario " + idComentario + " no encontrado")); 
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[borrarComentario] Incidencia " + idIncidencia + " no encontrada"));
		
		if (incidencia.getSolucion().equals(comentario.getAnotacion())) {
			incidencia.setSolucion("");
			incidencia.setEstado("Aceptada");
		}
		
		incidencia.getComentarios().remove(comentario);
		repoIncidencias.save(incidencia);
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		return "portal";
	}
	
	@PostMapping("/cerrarincidencia")
	public String cerrarIncidencia (Model model, HttpServletRequest request, @RequestParam Long idIncidencia) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[cerrarIncidencia] Incidencia " + idIncidencia + " no encontrada"));
		
		/*
		 * Por como está protegido el boton "Cerrar incidencia" en consultarincidencia.html esta comprobación sobraría, pero la
		 * dejo por si es necesaria más adelante
		 */
		if (incidencia.getEstado().equals("Solucionada")) {
			
			incidencia.setEstado("Cerrada");
			repoIncidencias.save(incidencia);
		}
		
		model.addAttribute("incidencia", incidencia);
		
		CargarDatosSesionHttpEnModelo (model, request);
		EstadosIncidencia (model, request, incidencia);
		
		return "consultarincidencia";
	}
	
	@PostMapping("/reabririncidencia")
	public String reabrirIncidencia (Model model, HttpServletRequest request, @RequestParam Long idIncidencia) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("[reabrirIncidencia] Incidencia " + idIncidencia + " no encontrada"));
		
		/*
		 * Por como está protegido el boton "Cerrar incidencia" en consultarincidencia.html esta comprobación sobraría, pero la
		 * dejo por si es necesaria más adelante
		 */
		if (incidencia.getEstado().equals("Solucionada") || incidencia.getEstado().equals("Cerrada")) {
			
			incidencia.setEstado("Abierta");
			incidencia.setSolucion("");
			incidencia.setAsignatario(null);
			repoIncidencias.save(incidencia);
		}

		model.addAttribute("incidencia", incidencia);
		
		CargarDatosSesionHttpEnModelo (model, request);
		EstadosIncidencia (model, request, incidencia);
		
		return "consultarincidencia";
	}	
	
}