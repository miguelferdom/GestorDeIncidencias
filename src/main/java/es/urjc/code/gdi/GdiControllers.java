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
		
	//creo una lista de incidencias para hacer de la aplicación con la información alojada en memoria
	//private List<Incidencia> incidencias = new ArrayList<>();
	//private List<String> hincidencias = new ArrayList<>();
	
	/* declaro el constructor vacio de la clase GdiControllers y lo uso para cargar información de incidencias en memoria
	public GdiControllers () {
		incidencias.add(new Incidencia(1L, "Alta", "Correo", "Aceptada", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99"));
		incidencias.add(new Incidencia(2L, "Alta", "Correo", "Abierta", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa"));
		incidencias.add(new Incidencia(3L, "Alta", "SW ventas", "Abierta", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen"));
		incidencias.add(new Incidencia(4L, "Alta", "SW RRHH", "Aceptada", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla"));
		incidencias.add(new Incidencia(5L, "Alta", "Microinformatica", "Abierta", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas"));
		incidencias.add(new Incidencia(6L, "Alta", "Infraestructura", "Aceptada", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar"));
		incidencias.add(new Incidencia(7L, "Alta", "Microinformatica", "Abierta", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus"));
		incidencias.add(new Incidencia(8L, "Alta", "Correo", "Abierta", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento."));
	
		hincidencias.add("Rojo");
		hincidencias.add("Verde");
		hincidencias.add("Azul");
	}*/
	
	@PostConstruct
	public void init() {
		/*
		repoIncidencias.save(new Incidencia("Alta", "Correo", "Aceptada", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99"));
		repoIncidencias.save(new Incidencia("Alta", "Correo", "Abierta", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa"));
		repoIncidencias.save(new Incidencia("Alta", "SW ventas", "Abierta", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen"));
		repoIncidencias.save(new Incidencia("Alta", "SW RRHH", "Aceptada", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla"));
		repoIncidencias.save(new Incidencia("Alta", "Microinformatica", "Abierta", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas"));
		repoIncidencias.save(new Incidencia("Alta", "Infraestructura", "Aceptada", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar"));
		repoIncidencias.save(new Incidencia("Alta", "Microinformatica", "Abierta", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus"));
		repoIncidencias.save(new Incidencia("Alta", "Correo", "Abierta", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento."));	
		*/
		
		repoUsuarios.save(new Usuario("user1", "1234", "usuario"));
		repoUsuarios.save(new Usuario("user2", "1234", "usuario"));
		repoUsuarios.save(new Usuario("user3", "1234", "usuario"));
		repoUsuarios.save(new Usuario("user4", "1234", "usuario"));
		repoUsuarios.save(new Usuario("tecn1", "1234", "tecnico"));
		repoUsuarios.save(new Usuario("tecn2", "1234", "tecnico"));
		repoUsuarios.save(new Usuario("tecn3", "1234", "tecnico"));
		repoUsuarios.save(new Usuario("tecn4", "1234", "tecnico"));
		repoUsuarios.save(new Usuario("admi1", "1234", "administrador"));
		repoUsuarios.save(new Usuario("admi2", "1234", "administrador"));
		repoUsuarios.save(new Usuario("admi3", "1234", "administrador"));
		repoUsuarios.save(new Usuario("admi4", "1234", "administrador"));

		/*
		repoComentarios.save(new Comentario("comentario 01"));
		repoComentarios.save(new Comentario("comentario 02"));
		repoComentarios.save(new Comentario("comentario 03"));
		repoComentarios.save(new Comentario("comentario 04"));
		repoComentarios.save(new Comentario("comentario 05"));
		repoComentarios.save(new Comentario("comentario 06"));
		repoComentarios.save(new Comentario("comentario 07"));
		repoComentarios.save(new Comentario("comentario 08"));
		repoComentarios.save(new Comentario("comentario 09"));
		repoComentarios.save(new Comentario("comentario 10"));
		repoComentarios.save(new Comentario("comentario 11"));
		repoComentarios.save(new Comentario("comentario 12"));
		repoComentarios.save(new Comentario("comentario 13"));
		repoComentarios.save(new Comentario("comentario 14"));
		repoComentarios.save(new Comentario("comentario 15"));
		repoComentarios.save(new Comentario("comentario 16"));
		repoComentarios.save(new Comentario("comentario 17"));
		repoComentarios.save(new Comentario("comentario 18"));
		repoComentarios.save(new Comentario("comentario 19"));
		repoComentarios.save(new Comentario("comentario 20"));
		repoComentarios.save(new Comentario("comentario 21"));
		repoComentarios.save(new Comentario("comentario 22"));
		repoComentarios.save(new Comentario("comentario 23"));
		repoComentarios.save(new Comentario("comentario 24"));
		repoComentarios.save(new Comentario("comentario 25"));
		repoComentarios.save(new Comentario("comentario 26"));
		repoComentarios.save(new Comentario("comentario 27"));
		repoComentarios.save(new Comentario("comentario 28"));
		repoComentarios.save(new Comentario("comentario 29"));
		repoComentarios.save(new Comentario("comentario 30"));
		*/
		
		Incidencia inc1 = new Incidencia("Alta", "Correo", "Aceptada", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99");
		Incidencia inc2 = new Incidencia("Alta", "Correo", "Abierta", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa");
		Incidencia inc3 = new Incidencia("Alta", "SW ventas", "Abierta", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen");
		Incidencia inc4 = new Incidencia("Alta", "SW RRHH", "Aceptada", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla");
		Incidencia inc5 = new Incidencia("Alta", "Microinformatica", "Abierta", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas");
		Incidencia inc6 = new Incidencia("Alta", "Infraestructura", "Aceptada", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar");
		Incidencia inc7 = new Incidencia("Alta", "Microinformatica", "Abierta", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus");
		Incidencia inc8 = new Incidencia("Alta", "Correo", "Abierta", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento.");	
		
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
	}
	
	@RequestMapping("/login")
	public String cargaLogin(Model model) {

		/*
		model.addAttribute("incidencias", incidencias);
		model.addAttribute("hincidencias", hincidencias);
		
		for (Incidencia in : incidencias){
			System.out.println(in.toString());
			System.out.println();
		}
		
		for (String hin : hincidencias){
			System.out.println(hin.toString());
			System.out.println();
		}
		*/
		
		model.addAttribute("incidencias", repoIncidencias.findAll());
		
		return "login.html";
	}
	
	@PostMapping("/bienvenida")
	public String cargaBienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		model.addAttribute("user", usuario);
		model.addAttribute("pass", password);
		model.addAttribute("profile", perfil);
		
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
	
	//@PostMapping("/volverabienvenida")
	@RequestMapping("/volverabienvenida")
	public String cargaVolverABienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		return "bienvenida_template";
	}
}