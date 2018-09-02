package song.type.night.controller;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.common.Variable;
import song.type.night.service.MemberService;
import song.type.night.vo.Member;

@Controller
public class LoginController{
	@Autowired
	private MemberService service;
	
	//로그인 페이지 매핑
	@RequestMapping(value="/")
	public String LoginPage() {
		return "/account/login";
	}
	
	//member login
	@RequestMapping(value="/logincheck.do")
	public ModelAndView Login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, 
			HttpServletResponse rep, ModelAndView mv) throws Exception {
		//crypto data
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(pwd.getBytes());
		
		//set Member
		Member m = new Member();
		m.setId(id);
		m.setPwd(new String(messageDigest.digest()));
		
		System.out.println("pwd " +pwd);
		
		//query the member
		int result = service.isMember(m);
		
		//login success
		if(result != -1) {
			//set Cookie
			Cookie c = new Cookie("uid", String.valueOf(result));
			c.setMaxAge(60 * 60 * 3600);
			rep.addCookie(c);
			
			mv.setViewName("redirect:/shop/list.do");
									
		} else {
			mv.setViewName("/account/login");
			mv.addObject("msg", String.valueOf(Variable.LOGIN_FAIL));
		}
		
		return mv;
	}
	
	//member logout
	//expire the cookie value
	@RequestMapping(value="/logout.do")
	public ModelAndView Logout(ModelAndView mv, HttpServletResponse rep) {
		Cookie c = new Cookie("uid", null);
		c.setMaxAge(0);
		rep.addCookie(c);
		
		mv.setViewName("redirect:/");
		mv.addObject("msg", String.valueOf(Variable.LOGOUT));
		return mv;
	}
}
