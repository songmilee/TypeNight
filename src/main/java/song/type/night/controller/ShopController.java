package song.type.night.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@RequestMapping(value="/shop", method=RequestMethod.GET)
	public ModelAndView shopPage(@CookieValue(value="uid") String uid) {
		ModelAndView mv = new ModelAndView("shop");
		mv.addObject("uid", uid);
		return mv;
	}

}
