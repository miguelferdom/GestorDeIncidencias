package es.urjc.code.gdi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GdiControllers {
	
	@RequestMapping("/login")
	public String cargaLogin(Model model) {

		//model.addAttribute("name", "World");

		return "login.html";
	}
	
	@PostMapping("/bienvenida")
	public String cargaBienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		model.addAttribute("user", usuario);
		model.addAttribute("pass", password);
		model.addAttribute("profile", perfil);
		
		return "bienvenida_template";
	}
	
	@RequestMapping("/nuevaincidencia")
	public String cargaNuevaIncidencia(Model model) {
		return "nuevaincidencia_template";
	}
	
	@PostMapping("/consultarincidencia")
	//@RequestMapping("/consultarincidencia")
	public String cargaConsultarIncidencia(Model model, @RequestParam String numincidencia) {
		
		//model.addAttribute("user", usuario);
		//model.addAttribute("pass", password);
		//model.addAttribute("profile", perfil);
		model.addAttribute("issuenumber", numincidencia);
				
		return "consultarincidencia_template";
	}
	
	//@PostMapping("/volverabienvenida")
	@RequestMapping("/volverabienvenida")
	public String cargaVolverABienvenida(Model model, @RequestParam String usuario, @RequestParam String password, @RequestParam String perfil) {
		
		return "bienvenida_template";
	}
}