package song.type.night.dao;

import song.type.night.VO.Member;

public interface TypeNightDAO {
	
	public boolean registerMember(Member m);
	public boolean isMember(Member m);
}
