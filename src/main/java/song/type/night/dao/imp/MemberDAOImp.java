package song.type.night.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import song.type.night.common.Variable;
import song.type.night.dao.MemberDAO;
import song.type.night.vo.Cart;
import song.type.night.vo.Item;
import song.type.night.vo.Member;

@Repository
public class MemberDAOImp implements MemberDAO {
	@Autowired
	private SqlSession db;
		
	
	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub		
		return db.insert(Variable.MEMBER + ".insertMember", m);
	}

	@Override
	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		return db.selectOne(Variable.MEMBER + ".selectOneMember", m);
	}

}
