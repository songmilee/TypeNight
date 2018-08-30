package song.type.night.dao.imp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import song.type.night.dao.TypeNightDAO;
import song.type.night.vo.Member;

@Repository
public class TypeNightDAOImp implements TypeNightDAO {
	@Autowired
	private SqlSession db;
	
	private static final String namespace = "song.type.night.mapper.Mapper";
	
	@Override
	public boolean registerMember(Member m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int isMember(Member m) {
		// TODO Auto-generated method stub
		
		int result = (db.selectOne(namespace + ".isMember", m) == null) ? -1 : db.selectOne(namespace + ".isMember", m);
		
		return result;
	}

}
