package song.type.night.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import song.type.night.common.Variable;
import song.type.night.service.CartService;
import song.type.night.vo.Cart;

@RestController
public class CartController  {
	@Autowired
	private CartService service;

	//cart에 아이템 추가
	//post
	@RequestMapping(value="/cart", method = RequestMethod.POST)
	public ModelAndView insertItem(@CookieValue(value="uid")String uid, @RequestParam("iid") int iid,
			@RequestParam("amount") int amount, ModelAndView mv) {
		Cart c = new Cart();
		c.setUid(Integer.parseInt(uid));
		c.setIid(iid);
		c.setAmount(amount);
		
		int cnt = service.countCartItem(c);
		
		if(cnt == 0) {
			service.insertCartItem(c);
		} else {
			service.updateCartItem(c);
		}
		
		mv.setViewName("redirect:/shop");
		
		return mv;
	}
	
	//get
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public ModelAndView listItem(@CookieValue(value="uid") String uid, ModelAndView mv) {
		mv.setViewName("/shop/cart");
		
		//total price
		float sum = service.totalPrice(Integer.parseInt(uid));
		List<Map<String, Object>> cartItem = service.totalCartItem(Integer.parseInt(uid));
		
		mv.addObject("sum", sum);
		mv.addObject("cartitem", cartItem);
		
		return mv;
	}
	
	//delete
	@RequestMapping(value="/cart", method=RequestMethod.DELETE)
	public Map<String, Object> deleteItem(@CookieValue(value="uid") String uid, @RequestParam("iid")String iid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Cart c = new Cart();
		c.setUid(Integer.parseInt(uid));
		c.setIid(Integer.parseInt(iid));
		
		service.deleteCart(c);
		
		map.put("result", Variable.RESULT_OK); 
		
		return map;
	}
}
