package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug(" insertMember(MemberVO vo) 호출 ");
		
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		
		logger.debug(" mysql 실행 완료!!! ");
	}
	
	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug(" loginMember(MemberVO vo) 호출 ");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		
		return resultVO;
	}
	
	@Override
	public MemberVO getMember(String userid) {
		logger.debug(" getMember(String userid) 호출 ");
		
		return sqlSession.selectOne(NAMESPACE + ".getMember", userid);
	}
	
	@Override
	public int updateMember(MemberVO uvo) {
		logger.debug(" updateMember(MemberVO vo) 호출 ");
		
		return sqlSession.update(NAMESPACE + ".updateMember", uvo);
	}
	
	@Override
	public int deleteMember(MemberVO dvo) {
		logger.debug(" deleteMember(MemberVO dvo) 호출 ");
		
		return sqlSession.delete(NAMESPACE + ".deleteMember",dvo);
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("getMemberList() 호출 ");
		
		return sqlSession.selectList(NAMESPACE + ".getMemberList");
	}
}
