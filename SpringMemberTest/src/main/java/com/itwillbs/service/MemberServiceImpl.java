package com.itwillbs.service;

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
		logger.debug(" S : memberJoin(MemberVO vo) 실행 ");
		logger.debug(" S : DAO 회원가입 처리 동작 호출 ");
		
		mdao.insertMember(vo);
		
		logger.debug(" S : 회원가입 완료 ");
		logger.debug(" S : 다시 컨트롤러로 이동 ");
		
	}
	
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug(" S : loginMember(MemberVO vo) 실행 ");
		logger.debug(" S : DAO 로그인 처리동작 호출 ");
		
		MemberVO resultVO = mdao.loginMember(vo);
		
		return resultVO;
	}
}
