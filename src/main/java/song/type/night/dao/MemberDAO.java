package song.type.night.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import song.type.night.vo.Cart;
import song.type.night.vo.Item;
import song.type.night.vo.Member;

public interface MemberDAO {
	public int insertMember(Member m);
	public Member selectOneMember(Member m);
}
