package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo);
	
	// 로그인 처리 동작
	public MemberVO loginMember(MemberVO vo);
	
	// 회원정보 조회 동작
	public MemberVO getMember(String userid);

}
