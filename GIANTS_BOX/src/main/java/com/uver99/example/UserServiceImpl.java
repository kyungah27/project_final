package com.uver99.example;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    
    //---BASIC -> SILVER 등업되는 로그인 최소 기준값
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    //---SILVER -> GOLD 등업되는 로그인 최소 기준값
    public static final int MIN_RECOMMEND_FOR_SILVER = 30;
    
    
    //---빈 생성--------------------------------------------
    private final UserDao     userDao;
    private final MailSender  mailSender;
	
	public UserServiceImpl(@Qualifier("userDaoImpl") 	  UserDao userDao
						  ,@Qualifier("dummyMailService") MailSender mailSender) {
		this.userDao = userDao;
		this.mailSender = mailSender;
	}
	
	
	
	//---메서드--------------------------------------------
	@Override
	public int doInsert(User user) {
		return userDao.doInsert(user);
	}
	
	@Override
	public int doDelete(User user){
		return userDao.doDelete(user);
	}

	@Override
	public int doUpdate(User user) {
		return userDao.doUpdate(user);
	}

	@Override
	public User doSelectOne(String id) {
		return userDao.doSelectOne(id);
	}

	@Override
	public List<User> doSelectList(User user) {
		return userDao.doSelectList(user);
	}
	
	
	
	
	
	/**
	 * 최초등록시 등급을 basic처리
	 * 비지니스 로직
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	@Override
	public int add(User user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		if(user.getLevel() == null) user.setLevel(Level.BASIC);
		
		flag = userDao.doInsert(user);
		LOG.debug("=========================");
		LOG.debug("=flag================"+flag);
		LOG.debug("=level================"+user.getLevel());
		LOG.debug("=========================");
		
		return flag;
	}


	@Override
	public void upgradeLevels(User user) throws Exception {
		List<User> list = userDao.doSelectList(user);
		for(User vo:list) {
			//업그래이드 가능 여부 판단  
			if(canUpgradeLevel(vo) == true) {
				//3.등업
				upgradeLevel(vo);
			}
		}
	}
	
	/**
	 * 등업 처리 
	 * @param user
	 */
	public void upgradeLevel(User user) {

		user.upgradeLevel();
		this.userDao.doUpdate(user);
		
		//email전송
		sendUpgradeEmail(user);
	}
	
	/**
	 * mail전송
	 * @param user
	 */
	public void sendUpgradeEmail(User user) {
		
		//-----------------------------------------------------------
        //POP 서버명 : pop.naver.comSMTP 
        //서버명 : smtp.naver.com
        //POP 포트 : 995, 
        //보안연결(SSL) 필요
        //SMTP 포트 : 465, 보안 연결(SSL) 
        //필요아이디 : jamesol
        //비밀번호 : 네이버 로그인 비밀번호
        //-----------------------------------------------------------
		String from  ="skyblueninz@naver.com";		
        String title    = user.getName()+"님 등업(https://cafe.naver.com/kndjang)";//제목
        String contents = user.getU_id()+"님 등급이 <br/>"+user.getLevel().name()+"로 등업 되었습니다.";//내용
        String recAddr  = user.getMail();//받는사람
        
        SimpleMailMessage  mimeMessage=new SimpleMailMessage();
        
    	//from
		mimeMessage.setFrom(from);
		//to
		mimeMessage.setTo(recAddr);
		//title
		mimeMessage.setSubject(title);
		//내용
		mimeMessage.setText(contents);
		
		LOG.debug("mailSender:"+mailSender);
		//전송
		this.mailSender.send(mimeMessage);
        
	}
	
	
	/**
	 * 업그래이드 가능 여부 확인
	 * @param user
	 * @return boolean
	 */
	private boolean canUpgradeLevel(User user) {
		
		Level currentLevel = user.getLevel();
		switch(currentLevel) {
		    case BASIC : return (user.getLogin()     >=MIN_LOGCOUNT_FOR_SILVER);
		    case SILVER: return (user.getRecommend() >=MIN_RECOMMEND_FOR_SILVER);
		    case GOLD : return false;
		    default : throw new IllegalArgumentException("Unknown Level:"+currentLevel);
		}
	}
	
	
	

	
	
}









