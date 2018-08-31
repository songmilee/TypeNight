package song.type.night.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.service.CartService;
import song.type.night.vo.Cart;

@RequestMapping(value="/cart/*")
@Controller
public class CartController {
	@Autowired
	private CartService service;
	
	//cart에 아이템 추가
	@RequestMapping(value="insert.do")
	public String insertItem(@CookieValue(value="uid")String uid, @RequestParam("iid") int iid,
			@RequestParam("amount") int amount) {
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
		
		return "redirect:/shop/list.do";
	}
	
	@RequestMapping(value="list.do")
	public ModelAndView listItem(@CookieValue(value="uid") String uid, ModelAndView mv) {
		mv.setViewName("/shop/cart");
		
		//total price
		float sum = service.totalPrice(Integer.parseInt(uid));
		List<Map<String, Object>> cartItem = service.totalCartItem(Integer.parseInt(uid));
		
		mv.addObject("sum", sum);
		mv.addObject("cartitem", cartItem);
		
		return mv;
	}
	
	@RequestMapping(value="delete.do")
	public String deleteItem(@CookieValue(value="uid") String uid, @RequestParam("iid")String iid) {
		Cart c = new Cart();
		c.setUid(Integer.parseInt(uid));
		c.setIid(Integer.parseInt(iid));
		
		service.deleteCart(c);
		
		return "redirect:/cart/list.do";
	}
}
