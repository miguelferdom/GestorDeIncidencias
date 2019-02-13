package es.urjc.code.gdi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	
	private List<Incidencia> incidencias;

	@PostConstruct
	public void init() {
		
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
		
		Incidencia inc1 = new Incidencia(user1, "Alta", "Correo", "Aceptada", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99");
		inc1.setAsignatario(tecn2);
		Incidencia inc2 = new Incidencia(user1, "Alta", "Correo", "Abierta", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa");
		Incidencia inc3 = new Incidencia(user2, "Alta", "SW ventas", "Abierta", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen");
		Incidencia inc4 = new Incidencia(user3, "Alta", "SW RRHH", "Aceptada", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla");
		inc4.setAsignatario(tecn1);
		Incidencia inc5 = new Incidencia(user4, "Alta", "Microinformatica", "Abierta", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas");
		Incidencia inc6 = new Incidencia(tecn1, "Alta", "Infraestructura", "Aceptada", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar");
		inc6.setAsignatario(admi2);
		Incidencia inc7 = new Incidencia(tecn2, "Alta", "Microinformatica", "Abierta", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus");
		Incidencia inc8 = new Incidencia(admi3, "Alta", "Correo", "Abierta", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento.");	
		
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
		return "nuevaincidencia_template";
	}
	
	@RequestMapping("/consultarincidencia")
	public String cargaConsultarIncidencia(Model model, @RequestParam String numincidencia) {
		
		model.addAttribute("issuenumber", numincidencia);
				
		return "consultarincidencia_template";
	}
	
	@RequestMapping("/volverabienvenida")
	public String cargaVolverABienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		return "bienvenida_template";
	}
}