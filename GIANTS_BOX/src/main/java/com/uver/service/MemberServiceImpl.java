package com.uver.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.dao.MemberDao;
import com.uver.dao.MemberDaoImpl;
import com.uver.vo.MemberVO;

	@Service("MemberServiceImpl")
	public class MemberServiceImpl implements MemberService {
		final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);
		@Autowired
		MemberDaoImpl memberDaoImpl;
	
		public MemberServiceImpl() {
		}
	
		@Override
		public void setMemberDaoImpl(MemberDaoImpl memberDaoImpl) {
			this.memberDaoImpl = memberDaoImpl;
		}
		
//		public MemberVO SelectOne(MemberVO inputUser) {
//			
//			
//			return MemberVO;
//		}
	
		/**
		 * 아이디 하나 조회
		 * @param inputUser
		 * @return
		 */
		public MemberVO selectOne(MemberVO inputUser) {
			
		MemberVO memberOne = memberDaoImpl.doSelectOneById(inputUser.getUserId());
			
			return memberOne;
		}
		
		/**
		 * 회원정보 수정
		 * @param inputUser
		 * @return
		 */
		public int myUpdate(MemberVO inputUser) {
			int flag = 0;
			
			flag = memberDaoImpl.doUpdata(inputUser);
			
			if(flag == 1) {
				LOG.debug("회원정보가 수정되었습니다.");
			}else{
				LOG.debug("회원정보를 다시 확인해주세요.");
			}
			
			return flag;
		}
		
		/**
		 * 아이디 중복 확인
		 * @param inputUser
		 * @return
		 */
		public int idCheck(MemberVO inputUser) {
			int flag = 0;
			ArrayList<MemberVO> arrayList = (ArrayList<MemberVO>) memberDaoImpl.doSelectList("10", "");
			ArrayList<Integer> arrayIndexList = new ArrayList<Integer>();
			
			LOG.debug(inputUser.getUserId());
			for(MemberVO memberAll:arrayList) {
			
			
				if(memberAll.getUserId().equals(inputUser.getUserId()) ) {
					LOG.debug("이미 가입된 아이디 입니다.");
					flag = 0;
					return flag;
				}else{	
					flag = 1;
				}
				
			}
			LOG.debug("사용할 수 있는 아이디 입니다.");
			
			return flag;
		}
		
		
		/**
		 * 회원가입
		 * @param inputuser
		 * @return
		 */
		@Override
		public int regMember(MemberVO inputUser) {
			int flag = 0;
			
			flag = memberDaoImpl.doInsert(inputUser);
			
			return flag;
		}
	
		/**
		 * 비밀번호조건
		 * 
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		@Override
		public int regPw(MemberVO inputUser) throws ClassNotFoundException, SQLException {
			int flag = 0;
	
			String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
	
			Matcher matcher = Pattern.compile(pwPattern).matcher(inputUser.getPassword());
			if (matcher.matches() == true) {
				LOG.debug("회원등록이 완료되었습니다.");
	
				flag = 1;
			} else {
				LOG.debug("영문자,숫자,특수문자를 조합해주세요");
			}
	
			return flag;
	
		}
	
		/**
		 * 로그인
		 * 
		 * @param user
		 */
		// View User loginUser 를줌 -> Controller ( Service.login(loginUser) ) ->
		// Service(userDaoImpl.doSelectList(); )
	
		MemberVO inputUser = new MemberVO();
	
		@Override
		public MemberVO login(MemberVO inputUser) {
			MemberVO resultVO = null;
	
			List<MemberVO> list = memberDaoImpl.doSelectListAll(); // H170_01
	
			for (MemberVO vo : list) {
				if (vo.getUserId().equals(inputUser.getUserId()) && vo.getPassword().equals(inputUser.getPassword())) {
					LOG.debug("로그인에 성공하셨습니다.");
					resultVO = vo;
				}
			}
			if (resultVO == null) {
				LOG.debug("아이디 혹은 비밀번호를 확앤해주세요");
			}
	
			return resultVO;
		}

		@Override
		public void logout(HttpSession session) {
			// TODO Auto-generated method stub
			
		}
	
		

	
	}
