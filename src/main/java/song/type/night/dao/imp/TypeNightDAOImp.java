package song.type.night.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import song.type.night.VO.Member;
import song.type.night.dao.TypeNightDAO;

@Repository
public class TypeNightDAOImp implements TypeNightDAO {
	@Autowired
	private JdbcTemplate db;
	
	private String query="";
	
	@Override
	public boolean registerMember(Member m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMember(Member m) {
		// TODO Auto-generated method stub
		query = "select * from member where member.id=\""+m.getId()+"\" and member.pwd=\""+m.getPwd()+"\"";
		List<Map<String, Object>> cur = db.queryForList(query);
		
		System.out.println(cur);
		
		if(cur.size() == 0) return false;
		
		return true;
	}

}
