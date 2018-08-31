package song.type.night.dao.imp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import song.type.night.common.Variable;
import song.type.night.dao.OrderDAO;
import song.type.night.vo.Order;

@Repository
public class OrderDAOImp implements OrderDAO {
	@Autowired
	private SqlSession db;

	@Override
	public void insertOrder(Order o) {
		// TODO Auto-generated method stub
		db.insert(Variable.ORDER + ".insertOrder", o);
		
	}

	@Override
	public List<Map<String, Object>> selectOrder(Order o) {
		// TODO Auto-generated method stub
		return db.selectList(Variable.ORDER + ".selectOrder", o);
	}

}
