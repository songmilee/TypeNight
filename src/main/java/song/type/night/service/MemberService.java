package song.type.night.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import song.type.night.dao.MemberDAO;
import song.type.night.dao.imp.MemberDAOImp;
import song.type.night.vo.Cart;
import song.type.night.vo.Item;
import song.type.night.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDAOImp dao;
	
	//login 시 회원가입된지 확인
	public int isMember(Member m) {
		Member result = dao.selectOneMember(m);
		
		if(result == null) return -1;
		
		return (result.getUid());
	}
	
	//회원 가입시 테이블에 등록
	public boolean registerMember(Member m) {
		int result = dao.insertMember(m);
		
		if(result == 0) return false;
		
		return true;
	}	
	
}
