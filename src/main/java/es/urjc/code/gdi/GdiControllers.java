package es.urjc.code.gdi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GdiControllers {
	
	@RequestMapping("/login")
	public String cargalogin(Model model) {

		//model.addAttribute("name", "World");

		return "login.html";
	}
}