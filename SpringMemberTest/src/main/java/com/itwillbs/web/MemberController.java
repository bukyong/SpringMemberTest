package com.itwillbs.web;

import javax.inject.Inject;

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
}
