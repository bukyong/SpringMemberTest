package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		logger.debug(" memberJoinGET() 호출 ");
		logger.debug(" /member/memberjoin.jsp로 이동 ");
	}
	
	// 회원가입 - POST
	@RequestMapping(value = "/memberjoin",method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPost() 호출 ");
		
		logger.debug(" 전달정보 vo : "+vo);
		
		mService.memberJoin(vo);
		logger.debug(" 회원가입 성공! ");
		
		return "redirect:/member/login";
	}
	
	// /member/login
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
	
	// /member/main
	// 메인페이지 - GET
	@GetMapping(value = "/main")
	public String memberMainGET() {
		logger.debug(" /member/main -> memberMainGET() 호출 ");

		return "/member/main";
	}
	
	// 로그아웃 - GET 
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.debug(" /member/logout -> memberLogoutGET() 호출 ");
		
		session.invalidate();
		logger.debug(" 세션객체 초기화(로그아웃) ");
		
		return "redirect:/member/main";
	}
	
	// /member/info
	// 회원정보 조회 - GET
	@RequestMapping(value = "/info",method = RequestMethod.GET)
	public void memberInfoGET(HttpSession session,Model model) {
		logger.debug("/member/info -> memberInfoGET() 호출");
		
		String id = (String) session.getAttribute("id");
		logger.debug(" id : "+id);
		
		MemberVO resultVO = mService.memberInfo(id);
		model.addAttribute("resultVO", resultVO);
		
		// 연결된 view페이지로 이동 (/member/info.jsp)
	}
	
	// /member/update
	// 회원정보 수정 - GET
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public void memberUpdateGET(HttpSession session, Model model) {
		logger.debug(" memberUpdateGET() 호출 ");
		
		String id = (String) session.getAttribute("id");
		
		MemberVO resultVO = mService.memberInfo(id);
		logger.debug(" resultVO :  "+resultVO);
		
		model.addAttribute("resultVO", resultVO);
		
		// 연결된 view페이지로 이동 (/member/update.jsp)
		
	}
	
	// 회원정보 수정 - POST
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO vo) {
		logger.debug(" memberUpdatePOST() 호출 ");
		
		logger.debug(" 수정할 정보 : "+vo);
		
		// 서비스 -> DAO 회원정보 수정동작 호출
		int result = mService.memberUpdate(vo);
		logger.debug(" 결과 : "+result);
		
		if(result == 1) {
			return "redirect:/member/main";
		}
		
		return "redirect:/member/update";
	}
	
	// /member/delete
	// 회원정보 삭제 - GET
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String memberDeleteGET() {
		logger.debug(" memberDeleteGET() 호출 ");
		
		return "/member/delete";		
	}
	
	// 회원정보 삭제 - POST
	@PostMapping(value = "/delete")
	public String memberDeletePOST(MemberVO vo, HttpSession session) {

		logger.debug(" vo(삭제 회원 정보) : "+vo);
		
		int result = mService.memberDelete(vo);
		logger.debug(" 결과 : "+result);
		
		if(result == 1) {
			session.invalidate();
			
			return "redirect:/member/main";
		}
		
		return "redirect:/member/delete";
	}
	
	// 회원목록 조회(관리자 기능) - GET
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String memberListGET(HttpSession session, Model model) {
		logger.debug(" memberListGET() 호출 ");
		
		String id = (String) session.getAttribute("id");
		
		if( id == null || !id.equals("admin")) {
			return "redirect:/member/login";
		}
		
		List<MemberVO> memberList = mService.memberList();

		model.addAttribute("memberList", memberList);
			    	
		return "/member/list";
	}
}
