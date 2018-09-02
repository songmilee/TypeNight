package song.type.night.controller;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.common.Variable;
import song.type.night.service.MemberService;
import song.type.night.vo.Member;

@Controller
@RequestMapping(value="register/*")
public class RegisterController {
	@Autowired
	private MemberService service;

	@RequestMapping(value="main.do")
	public String registerPage() {
		return "/account/register";
	}
	
	@RequestMapping(value="regdata.do")
	public ModelAndView registerMember(@RequestParam("id") String id, @RequestParam("pwd") String pwd, 
			@RequestParam("name") String name, @RequestParam("gender") int gender, @RequestParam("birth") String birth, ModelAndView mv) throws Exception {
		
		//crypto data
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(pwd.getBytes());
		
		//create Member
		Member nb = new Member();
		nb.setId(id);
		nb.setPwd(new String(messageDigest.digest()));
		nb.setName(name);
		nb.setGender(gender);
		nb.setBirth(birth);
		
		//check Member
		int check = service.isMember(nb);
		
		//data exist
		if(check != -1) {
			mv.setViewName("/account/register");
			mv.addObject("msg", String.valueOf(Variable.REG_DATA_ALREADY));
		} else {
			//register Member
			boolean result = service.registerMember(nb);
			
			if(result) {
				mv.setViewName("redirect:/");
			} else {
				mv.setViewName("/account/register");
				mv.addObject("msg", String.valueOf(Variable.RESULT_FAIL));
			}			
		}
		
		return mv;
	}
}
