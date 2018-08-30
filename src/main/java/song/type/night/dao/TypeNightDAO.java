package song.type.night.dao;

import org.apache.ibatis.annotations.Mapper;

import song.type.night.vo.Member;

@Mapper
public interface TypeNightDAO {
	public boolean registerMember(Member m);
	public int isMember(Member m);
}
