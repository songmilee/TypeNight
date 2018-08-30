package song.type.night.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import song.type.night.VO.Member;
import song.type.night.dao.imp.TypeNightDAOImp;

@Controller
public class LoginController {
	@Autowired
	private TypeNightDAOImp typeDao;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String LoginPage() {
		return "login";
	}
	
	/**
	 * member 정보가 있으면 -> shop으로 이동
	 * member 정보가 없으면 -> login 화면으로 이동
	 * */
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String Login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, 
			HttpServletResponse rep) throws Exception {
		
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		
		boolean result = typeDao.isMember(m);
		
		if(result) {
			//set Cookie
			Cookie c = new Cookie("info", id);
			c.setMaxAge(60 * 60 * 3600);
			
			rep.addCookie(c);
			
			
			return "shop";
		}
		
		return "login";
	}
}
