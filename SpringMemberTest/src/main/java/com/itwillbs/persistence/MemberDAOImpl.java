package com.itwillbs.persistence;

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
		logger.debug(" insertMember(MemberVO vo) 실행 ");
		logger.debug(" sqlSession 사용 -> mapper 호출 ");
		
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		
		logger.debug(" mysql 실행 완료!!! ");
	}
}
