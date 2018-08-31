package song.type.night.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import song.type.night.dao.imp.CartDAOImp;
import song.type.night.dao.imp.OrderDAOImp;
import song.type.night.vo.Cart;
import song.type.night.vo.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDAOImp dao;
	
	@Autowired
	private CartDAOImp cart;
	
	//add order items
	public void insertOrder(Order o) {
		dao.insertOrder(o);
		
		Cart c = new Cart();
		c.setIid(o.getIid());
		c.setUid(o.getUid());
		
		cart.deleteCart(c);
	}
	
	//get order items
	public List<Map<String, Object>> getOrders(Order o){
		return dao.selectOrder(o);
	}
	
}
