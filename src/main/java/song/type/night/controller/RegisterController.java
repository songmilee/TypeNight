package song.type.night.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerMember(@RequestParam("id") String id, @RequestParam("pwd") String pwd, 
			@RequestParam("name") String name, @RequestParam("gender") boolean gender, @RequestParam("birth") String birth) {
		return "register";
	}
}
