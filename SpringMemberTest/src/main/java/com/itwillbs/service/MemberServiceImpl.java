package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberVO vo) {
		logger.debug(" memberJoin(MemberVO vo) 실행 ");
		logger.debug(" DAO 회원가입 처리 동작 호출 ");
		
		mdao.insertMember(vo);
		
		logger.debug(" 회원가입 완료 ");
		logger.debug(" 다시 컨트롤러로 이동 ");
		
	}
	
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug(" loginMember(MemberVO vo) 실행 ");
		logger.debug(" DAO 로그인 처리동작 호출 ");
		
		MemberVO resultVO = mdao.loginMember(vo);
		
		return resultVO;
	}
	
	@Override
	public MemberVO memberInfo(String id) {
		logger.debug(" memberInfo(String id) 실행 ");
		logger.debug(" DAO 회원정보 조회 처리동작 호출 ");
		
		MemberVO resultVO = mdao.getMember(id);
		
		logger.debug(" 회원정보 조회 끝, 정보를 컨트롤러로 전송 ");	
		
		return resultVO;
	}
	
	@Override
	public int memberUpdate(MemberVO vo) {
		logger.debug(" S : memberUpdate(MemberVO vo) 실행 ");
		logger.debug(" S : DAO 회원정보 수정 처리동작 호출 ");
		
		return mdao.updateMember(vo);
	}
	
	@Override
	public int memberDelete(MemberVO vo) {
		logger.debug(" S : memberDelete(MemberVO vo) 실행 ");
		logger.debug(" S : DAO 회원정보 삭제 처리동작 호출 ");
		
		return mdao.deleteMember(vo);
	}
	
	@Override
	public List<MemberVO> memberList() {
		logger.debug(" S : memberList() 실행 ");
		
		return mdao.getMemberList();
	}
}
