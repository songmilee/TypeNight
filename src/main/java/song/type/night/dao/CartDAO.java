package song.type.night.dao;

import java.util.List;
import java.util.Map;

import song.type.night.vo.Cart;

public interface CartDAO {
	public int countCartItem(Cart c);
	public void insertCart(Cart c);
	public void updateCart(Cart c);
	public List<Cart> selectCart(int uid);
	public float sumPrice(int uid);
	public List<Map<String, Object>> selectCartItemList(int uid);
	public void deleteCart(Cart c);
}
