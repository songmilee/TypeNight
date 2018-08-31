package song.type.night.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import song.type.night.common.Variable;
import song.type.night.dao.ItemDAO;
import song.type.night.vo.Item;

@Repository
public class ItemDAOImp implements ItemDAO {
	@Autowired
	private SqlSession db;
	
	@Override
	public List<Item> selectItem() {
		// TODO Auto-generated method stub
		return db.selectList(Variable.namespace + ".selectItem");
	}

	@Override
	public Item selectOneItem(int iid) {
		// TODO Auto-generated method stub
		return db.selectOne(Variable.namespace + ".selectOneItem", iid);
	}
}
