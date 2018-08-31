package song.type.night.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.service.OrderService;
import song.type.night.vo.Order;

@RequestMapping(value="/order/*")
@Controller
public class OrderController {
	@Autowired
	OrderService service;
	
	@RequestMapping(value="buy.do")
	public String buyItems(@CookieValue(value="uid")String uid, int[] iid, int[] amount) {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		
		for(int i = 0; i < iid.length; i++) {
			Order o = new Order();
			o.setIid(iid[i]);
			o.setAmount(amount[i]);
			o.setUid(Integer.parseInt(uid));
			o.setDate(sdf.format(d));
			
			service.insertOrder(o);
		}
		
		return "redirect:/shop/list.do";
	}
	
	@RequestMapping(value="list.do")
	public ModelAndView listOrders(ModelAndView mv, @CookieValue("uid") String uid) {
		mv.setViewName("/shop/orders");
		
		Order o = new Order();
		o.setUid(Integer.parseInt(uid));

		mv.addObject("orders", service.getOrders(o));
		
		return mv;
	}

}
