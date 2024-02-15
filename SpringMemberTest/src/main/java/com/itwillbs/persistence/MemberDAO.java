package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo);
	
	// 로그인 처리 동작
	public MemberVO loginMember(MemberVO vo);
	
	// 회원정보 조회 동작
	public MemberVO getMember(String userid);
	
	// 회원정보 수정 동작
	public int updateMember(MemberVO uvo);
	
	// 회원정보 삭제 동작
	public int deleteMember(MemberVO dvo);
	
	// 회원목록 조회 동작
	public List<MemberVO> getMemberList();
}
