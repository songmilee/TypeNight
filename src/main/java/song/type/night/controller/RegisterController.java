package song.type.night.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@ResponseBody
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerMember(@RequestParam("id") String id, @RequestParam("pwd") String pwd, 
			@RequestParam("name") String name, @RequestParam("gender") String gender, @RequestParam("birth") String birth) throws Exception {
		
		System.out.println("Register");
		
		Map<String, Object> message = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		message.put("result", 1);
		
		return mapper.writeValueAsString(message);
	}
}
