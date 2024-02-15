package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo);

}
