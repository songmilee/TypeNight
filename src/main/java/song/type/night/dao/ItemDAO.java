package song.type.night.dao;

import java.util.List;

import song.type.night.vo.Item;

public interface ItemDAO {
	public List<Item> selectItem();
	public Item selectOneItem(int iid);
}
