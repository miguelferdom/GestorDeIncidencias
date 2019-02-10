package es.urjc.code.gdi;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GdiControllers {
	
	//creo una lista de incidencias para hacer de la aplicación con la información alojada en memoria
	private ArrayList<Incidencia> incidencias = new ArrayList<>();
	
	// declaro el constructor vacio de la clase GdiControllers y lo uso para cargar información de incidencias en memoria
	public GdiControllers () {
		incidencias.add(new Incidencia("Alta", "Correo", "Aceptada", "solicitud de nuevo correo electronico", "Necesitamos un buzon de correo para el compañero user99"));
		incidencias.add(new Incidencia("Alta", "Correo", "Abierta", "Baja de correo electronico", "solicitamos eliminar el buzon de correo del usuario user98 por causar baja en la empresa"));
		incidencias.add(new Incidencia("Alta", "SW ventas", "Abierta", "No cargan los nuevos artículos", "Desde el departamento de ventas vemos que los nuevos artículos que se han introducido en nuestro catálogo desde principios de esta semana no nos aparecen al hacer las consultas del stock general del álmacen"));
		incidencias.add(new Incidencia("Alta", "SW RRHH", "Aceptada", "Usuario duplicado en Directorio Activo", "Solicitamos que se elimine del directorio activo el usuario user97 ya que se trata de la misma persona que user99 que ha pasado de ser becario a formar parte de la plantilla"));
		incidencias.add(new Incidencia("Alta", "Microinformatica", "Abierta", "solicitud de nuevo equipo", "Necesitamos un nuevo portátil para el compañero user99 con el software necesario para el departamento de ventas"));
		incidencias.add(new Incidencia("Alta", "Infraestructura", "Aceptada", "Error Cluster Maquetación", "El servidor 1 del cluster del departamento de maquetación ha caido y al arrancar da un error de pantallazo azul y no termina de levantar"));
		incidencias.add(new Incidencia("Alta", "Microinformatica", "Abierta", "Posible virus en correo", "El equipo del usuario parece haber estado enviando correos de spam a toda su agenda de contactos. Hemos dejado el equipo apagado, solitamos que se revise por si tuviera virus"));
		incidencias.add(new Incidencia("Alta", "Correo", "Abierta", "solicitud de aumento de cuota", "Solicito un aumento de la capacidad de mi correo electronico, recibo y envio muchos correos diariamente con adjuntos pesados y trabajar con el archivado local me hace ir mucho más lento."));
	}
	
	@RequestMapping("/login")
	public String cargaLogin(Model model) {

		model.addAttribute("incidencias", incidencias);
		return "login.html";
	}
	
	@PostMapping("/bienvenida")
	public String cargaBienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		model.addAttribute("user", usuario);
		model.addAttribute("pass", password);
		model.addAttribute("profile", perfil);
		
		if (usuario.equals("usuario"))
		{
			return "bienvenida_template";
		}
		else {
			return "bienvenida_tec_template";
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