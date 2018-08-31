package song.type.night.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.service.ItemService;

@Controller
@RequestMapping(value="/shop/*")
public class ShopController {
	@Autowired
	private ItemService service;
	
	//상품 전체 목록
	@RequestMapping(value="list.do")
	public ModelAndView ListItem(@CookieValue(value="uid") String uid, ModelAndView mv) {
		mv.setViewName("/shop/list");

		mv.addObject("uid", uid);
		mv.addObject("items", service.getAllItems());
		
		return mv;
	}
	
	//상품 상세
	@RequestMapping(value="/detail/{iid}")
	public ModelAndView ItemDetail(@PathVariable("iid") int iid,@CookieValue(value="uid") String uid, ModelAndView mv) {
		mv.setViewName("/shop/detail");
		mv.addObject("item", service.getItem(iid));
		return mv;
	}
}
