package song.type.night.dao;

import java.util.List;
import java.util.Map;

import song.type.night.vo.Order;

public interface OrderDAO {
	public void insertOrder(Order o);
	public List<Map<String,Object>> selectOrder(Order o);
}
