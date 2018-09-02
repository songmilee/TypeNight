package song.type.night.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import song.type.night.service.OrderService;
import song.type.night.vo.Order;

@Controller
public class OrderController {
	@Autowired
	OrderService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception{
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		final CustomDateEditor dateEditor = new CustomDateEditor(df, true) {
	        @Override
	        public void setAsText(String text) throws IllegalArgumentException {
	            if ("today".equals(text)) {
	                setValue(new Date());
	            } else {
	                super.setAsText(text);
	            }
	        }
	    };
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
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
		
		return "redirect:/shop";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public ModelAndView listOrders(ModelAndView mv, @CookieValue("uid") String uid, 
			@RequestParam(value="start", defaultValue="today") Date  start, 
			@RequestParam(value="end", defaultValue="today") Date  end) {
		
		mv.setViewName("/shop/orders");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(start == null) start = new Date();
		if(end == null) end = new Date();
		
		Order o = new Order();
		o.setUid(Integer.parseInt(uid));
		o.setStart(sdf.format(start));
		o.setEnd(sdf.format(end));

		mv.addObject("orders", service.getOrders(o));
		
		return mv;
	}

}
