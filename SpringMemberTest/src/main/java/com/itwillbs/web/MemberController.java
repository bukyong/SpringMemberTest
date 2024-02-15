package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Inject
	private MemberService mService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// /member/memberjoin
	// 회원가입 - GET
	@RequestMapping(value = "/memberjoin",method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug(" memberJoinGET() 실행 ");
		logger.debug(" /member/memberjoin.jsp로 이동 ");
	}
	
	// 회원가입 - POST
	@RequestMapping(value = "/memberjoin",method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPost() 실행 ");
		
		logger.debug(" 전달정보 vo : "+vo);
		
		mService.memberJoin(vo);
		logger.debug(" 회원가입 성공! ");
		
		return "redirect:/member/login";
	}
	
	// 로그인 - GET
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug(" /member/login -> memberLoginGET() 호출 ");
		logger.debug(" /member/login.jsp 페이지 연결 ");
	}
	
	// 로그인 - POST
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo, HttpSession session) {
		logger.debug(" login.jsp ->memberLoginPOST() 호출 ");
		
		logger.debug(" 로그인 정보 vo : "+vo);
		
		MemberVO resultVO = mService.memberLogin(vo);
		
		String addr ="";
		if(resultVO == null) {
			logger.debug(" 로그인 실패! -> 다시 로그인 ");
			addr = "/member/login";
		} else {
			logger.debug(" 로그인 성공!! -> 메인페이지 ");
			
			session.setAttribute("id", resultVO.getUserid());

			addr = "/member/main";
		}		
		
		return "redirect:"+addr;
	}
}
