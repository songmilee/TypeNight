package song.type.night.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import song.type.night.dao.imp.ItemDAOImp;
import song.type.night.vo.Item;

@Service
public class ItemService {
	@Autowired
	private ItemDAOImp dao;
	//상품 목록을 가져옴
		public List<Item> getAllItems(){
			return dao.selectItem();
		}
		
		//상품 상세 정보를 가져옴
		public Item getItem(int iid) {
			return dao.selectOneItem(iid);
		}

}
