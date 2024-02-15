package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 회원가입 처리 메서드
	public void memberJoin(MemberVO vo);
	
	// 회원 로그인 메서드
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보 조회 메서드
	public MemberVO memberInfo(String id);
	
	// 회원정보 수정 메서드
	public int memberUpdate(MemberVO vo);
	
	// 회원정보 삭제 메서드
	public int memberDelete(MemberVO vo);
}
