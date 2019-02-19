package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		Usuario user1 = new Usuario("user1", "1234", "usuario");
		Usuario user2 = new Usuario("user2", "1234", "usuario");
		Usuario user3 = new Usuario("user3", "1234", "usuario");
		Usuario user4 = new Usuario("user4", "1234", "usuario");
		Usuario tecn1 = new Usuario("tecn1", "1234", "tecnico");
		Usuario tecn2 = new Usuario("tecn2", "1234", "tecnico");
		Usuario tecn3 = new Usuario("tecn3", "1234", "tecnico");
		Usuario tecn4 = new Usuario("tecn4", "1234", "tecnico");
		Usuario admi1 = new Usuario("admi1", "1234", "administrador");
		Usuario admi2 = new Usuario("admi2", "1234", "administrador");
		Usuario admi3 = new Usuario("admi3", "1234", "administrador");
		Usuario admi4 = new Usuario("admi4", "1234", "administrador");
		
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
		Incidencia inc3 = new Incidencia(user2, dpto2, "SW Ventas no recupera datos", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen");
		Incidencia inc4 = new Incidencia(user3, dpto4, "Baja empleado", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla");
		inc4.setAsignatario(tecn1);
		inc4.setEstado("Aceptada");
		Incidencia inc5 = new Incidencia(user4, dpto3, "Entrega de PC", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas");
		Incidencia inc6 = new Incidencia(tecn1, dpto5, "Caida de servidor", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar");
		inc6.setAsignatario(admi2);
		inc6.setEstado("Aceptada");
		Incidencia inc7 = new Incidencia(tecn2, dpto5, "Antivirus", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus");
		Incidencia inc8 = new Incidencia(admi3, dpto1, "Alta de correo", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento.");	
		
		inc1.getComentarios().add(new Comentario("comentario 01"));
		inc1.getComentarios().add(new Comentario("comentario 02"));
		inc1.getComentarios().add(new Comentario("comentario 03"));
		inc1.getComentarios().add(new Comentario("comentario 04"));
		inc1.getComentarios().add(new Comentario("comentario 05"));
		repoIncidencias.save(inc1);
		inc2.getComentarios().add(new Comentario("comentario 06"));
		inc2.getComentarios().add(new Comentario("comentario 07"));
		inc2.getComentarios().add(new Comentario("comentario 08"));
		inc2.getComentarios().add(new Comentario("comentario 09"));
		inc2.getComentarios().add(new Comentario("comentario 10"));
		repoIncidencias.save(inc2);
		inc3.getComentarios().add(new Comentario("comentario 11"));
		inc3.getComentarios().add(new Comentario("comentario 12"));
		inc3.getComentarios().add(new Comentario("comentario 13"));
		inc3.getComentarios().add(new Comentario("comentario 14"));
		inc3.getComentarios().add(new Comentario("comentario 15"));
		repoIncidencias.save(inc3);
		inc4.getComentarios().add(new Comentario("comentario 16"));
		inc4.getComentarios().add(new Comentario("comentario 17"));
		inc4.getComentarios().add(new Comentario("comentario 18"));
		inc4.getComentarios().add(new Comentario("comentario 19"));
		inc4.getComentarios().add(new Comentario("comentario 20"));
		repoIncidencias.save(inc4);
		inc5.getComentarios().add(new Comentario("comentario 21"));
		inc5.getComentarios().add(new Comentario("comentario 22"));
		inc5.getComentarios().add(new Comentario("comentario 23"));
		inc5.getComentarios().add(new Comentario("comentario 24"));
		inc5.getComentarios().add(new Comentario("comentario 25"));
		repoIncidencias.save(inc5);
		inc6.getComentarios().add(new Comentario("comentario 26"));
		inc6.getComentarios().add(new Comentario("comentario 27"));
		inc6.getComentarios().add(new Comentario("comentario 28"));
		inc6.getComentarios().add(new Comentario("comentario 29"));
		inc6.getComentarios().add(new Comentario("comentario 30"));
		repoIncidencias.save(inc6);
		inc7.getComentarios().add(new Comentario("comentario 31"));
		inc7.getComentarios().add(new Comentario("comentario 32"));
		inc7.getComentarios().add(new Comentario("comentario 33"));
		inc7.getComentarios().add(new Comentario("comentario 34"));
		inc7.getComentarios().add(new Comentario("comentario 35"));
		repoIncidencias.save(inc7);
		inc8.getComentarios().add(new Comentario("comentario 36"));
		inc8.getComentarios().add(new Comentario("comentario 37"));
		inc8.getComentarios().add(new Comentario("comentario 38"));
		inc8.getComentarios().add(new Comentario("comentario 39"));
		inc8.getComentarios().add(new Comentario("comentario 40"));
		repoIncidencias.save(inc8);
		
		incidencias = repoIncidencias.findAll();
	}
	
	@RequestMapping("/login")
	public String cargaLogin(Model model) {
			
		return "login.html";
	}
	
	@PostMapping("/bienvenida")
	public String cargaBienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		model.addAttribute("user", usuario);
		model.addAttribute("pass", password);
		model.addAttribute("profile", perfil);
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		// Si el perfil es igual a la cadena "usuario"..., si no lo es, entonces será tecnico o administrador y se le manda a otro portal
		if (perfil.equals("usuario"))
		{
			return "portalusuario";
		}
		else {
			return "portaltecnico";
		}
	}
	
	@RequestMapping("/nuevaincidencia")
	public String cargaNuevaIncidencia(Model model) {
		return "nuevaincidencia";
	}
	
	@GetMapping("/consultarincidencia")
	public String cargaConsultarIncidencia(Model model, @RequestParam Long numincidencia) {
		
		Incidencia incidencia = repoIncidencias.findById(numincidencia).orElseThrow(()-> new EntityNotFoundException("Incidencia " + numincidencia + " no encontrada"));
		
		boolean estaAsignada;
		model.addAttribute("incidencia", incidencia);
		if (incidencia.getAsignatario()!=null) {
			estaAsignada = true;
		}
		else {
			estaAsignada = false;
		}
		model.addAttribute("estaAsignada", estaAsignada);
		
		return "consultarincidencia";
	}
	
	/*
	 * Revisar si tengo que eliminar este controlador, creo que ahora mismo no tiene uso
	 */
	@RequestMapping("/volverabienvenida")
	public String cargaVolverABienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		return "bienvenida_template";
	}
	
	@PostMapping("/crearincidencia")
	public String crearIncidencia (Model model, @RequestParam String usuario, @RequestParam String departamento, @RequestParam String problema, @RequestParam String titulo, @RequestParam String descripcion) {
		
		Usuario userAux = new Usuario();
		userAux.setNombre(usuario);
		
		Long idUser = 0L;
		
		Departamento dptoAux = new Departamento ();
		dptoAux.setNombreDepartamento(departamento);
		
		Long idDpto = 0L;
		
		for (Usuario u : repoUsuarios.findAll()) {
			if (u.equals(userAux)) {
				idUser = u.getIdUsuario();
			}
		}
		
		userAux = repoUsuarios.getOne(idUser);
		
		//System.out.println("- - - - traza usuario - - - ");
		//System.out.println("idUser: " + idUser);
		//userAux.toString();
		//System.out.println("- - - - traza usuario - - - ");
		
		for (Departamento d : repoDepartamentos.findAll()) {
			if (d.equals(dptoAux)) {
				idDpto = d.getIdDepartamento();
			}
		}
		
		dptoAux = repoDepartamentos.getOne(idDpto);
		
		//System.out.println("- - - - traza dpto - - - ");
		//System.out.println("idDpto: " + idDpto);
		//dptoAux.toString();
		//System.out.println("- - - - traza dpto - - - ");
		
		repoIncidencias.save(new Incidencia(userAux, dptoAux, problema, titulo, descripcion));
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		return "portaltecnico";
	}
	
	@PostMapping("/aceptarincidencia")
	public String aceptarincidencia (Model model, @RequestParam Long idIncidencia, @RequestParam String asignatario) {
		
		Incidencia incidencia = repoIncidencias.findById(idIncidencia).orElseThrow(()-> new EntityNotFoundException("Incidencia " + idIncidencia + " no encontrada"));
		
		Usuario userAsignatario = obtenerUsuario(asignatario);
		
		incidencia.setAsignatario(userAsignatario);
		incidencia.setEstado("Aceptada");
		
		repoIncidencias.save(incidencia);
		model.addAttribute("incidencia", incidencia);
		
		boolean estaAsignada;
		if (incidencia.getAsignatario()!=null) {
			estaAsignada = true;
		}
		else {
			estaAsignada = false;
		}
		model.addAttribute("estaAsignada", estaAsignada);
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		return "portaltecnico";
	}
}