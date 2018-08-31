package song.type.night.dao.imp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import song.type.night.common.Variable;
import song.type.night.dao.CartDAO;
import song.type.night.vo.Cart;

@Repository
public class CartDAOImp implements CartDAO {
	@Autowired
	private SqlSession db;
	
	@Override
	public int countCartItem(Cart c) {
		// TODO Auto-generated method stub
		return db.selectOne(Variable.namespace + ".countCartItem", c);
	}

	@Override
	public void insertCart(Cart c) {
		// TODO Auto-generated method stub
		db.insert(Variable.namespace + ".insertCart", c);
	}

	@Override
	public void updateCart(Cart c) {
		// TODO Auto-generated method stub
		db.update(Variable.namespace + ".updateCart", c);
	}

	@Override
	public List<Cart> selectCart(int uid) {
		// TODO Auto-generated method stub
		return db.selectList(Variable.namespace + ".selectCart", uid);
	}

	@Override
	public float sumPrice(int uid) {
		// TODO Auto-generated method stub
		return db.selectOne(Variable.namespace + ".sumCartPrice",	uid);
	}

	@Override
	public List<Map<String, Object>> selectCartItemList(int uid) {
		// TODO Auto-generated method stub
		return db.selectList(Variable.namespace + ".selectCartItem", uid);
	}

	@Override
	public void deleteCart(Cart c) {
		// TODO Auto-generated method stub
		db.delete(Variable.namespace+".deleteCartItem", c);		
	}

}
