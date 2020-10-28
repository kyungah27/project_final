package com.uver.example;

import static com.uver.example.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.uver.example.UserServiceImpl.MIN_RECOMMEND_FOR_SILVER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;


//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                 "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestUserService {
	static final Logger LOG = LoggerFactory.getLogger(TestUserService.class);
	
    @Autowired //테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
    ApplicationContext  context;
    
    @Autowired
    UserDaoImpl userDao;
    
    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;
     
    @Autowired
    PlatformTransactionManager transactionManager;
    
    @Autowired
    @Qualifier("dummyMailService")
    MailSender mailSender;
    
    private List<User> users;
    
	@Before
	public void setUp() throws Exception {
		LOG.debug("=========================");
		LOG.debug("=setUp()=");
		users = Arrays.asList(
				new User("H120_01","전현정_01","1234",Level.BASIC,MIN_LOGCOUNT_FOR_SILVER-1,0,"skyblueninz@naver.com","")//BASIC
				,new User("H120_02","전현정_02","1234",Level.BASIC,MIN_LOGCOUNT_FOR_SILVER,0,"skyblueninz@naver.com","")//BASIC ->SILVER
				,new User("H120_03","전현정_03","1234",Level.SILVER,60,MIN_RECOMMEND_FOR_SILVER-1,"skyblueninz@naver.com","")//SILVER
				,new User("H120_04","전현정_04","1234",Level.SILVER,70,MIN_RECOMMEND_FOR_SILVER,"skyblueninz@naver.com","")//SILVER->GOLD
				,new User("H120_05","전현정_05","1234",Level.GOLD,99,MIN_RECOMMEND_FOR_SILVER+3,"skyblueninz@naver.com","")//GOLD
				);
		LOG.debug("=========================");
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("=========================");
		LOG.debug("=tearDown()=");		
		LOG.debug("=========================");
	}
	
	
	
	@Test
	@Ignore
	public void test() {
		System.out.println("jUnit test");
	}
	
	
	
	
	
	
	
	@Test
	@Ignore
	public void bean() {
		LOG.debug("=========================");
		LOG.debug("=bean()=");
		LOG.debug("=context:"+context);
		LOG.debug("=dao:"+userDao);
		LOG.debug("=transactionManager:"+transactionManager);		
		LOG.debug("=userService:"+userService);
		LOG.debug("=mailSender:"+this.mailSender);
		LOG.debug("=========================");
		
		assertThat(context, is(notNullValue()));
		assertThat(userDao, is(notNullValue()));
		assertThat(userService, is(notNullValue()));
		assertThat(transactionManager, is(notNullValue()));
		
	}
	
	
	/**
	 * 최초등록시 Level이 null이면 Basic으로 처리
	 * 1. 모두삭제
	 * 2. Level null
	 * 3. 등록
	 * 4. 조회 및 비교
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Ignore
	public void add() throws ClassNotFoundException, SQLException {
		//1.
		deleteAll();
		User user = users.get(4);
		
		User notNullUser = users.get(0);
		
		//2.
		user.setLevel(null);
		
		//3.
		this.userService.add(user);
		this.userService.add(notNullUser);
		
		//4.
		User vsUser = this.userDao.doSelectOne(user.getU_id());
		
		User vsNotNullUser = this.userDao.doSelectOne(notNullUser.getU_id());
		
		LOG.debug("vsUser:"+vsUser.getLevel());
		LOG.debug("vsNotNullUser:"+vsNotNullUser.getLevel());
		assertThat(vsUser.getLevel(), is(Level.BASIC));
		assertThat(vsNotNullUser.getLevel(), is(Level.BASIC));
		
	}
	
	
	
	
	
	
	
	
	
	private void deleteAll() throws ClassNotFoundException, SQLException {
		for(User vo :users) {
			this.userDao.doDelete(vo);
		}
	}
	
	
	
	@Test
//	@Ignore
	public void upgradeLevels() throws ClassNotFoundException, SQLException {
		//--------------------------------------------------------------
		//1. 기존데이터 삭제
		//2. 픽스처 데이터 등록
		//3. 등업
		//4. 비교
		//--------------------------------------------------------------
		//1
		for(User vo :users) {
			this.userDao.doDelete(vo);
		}		
		
		//2
		for(User vo :users) {
			this.userDao.doInsert(vo);
		}			
		
		User searchUser=new User();
		searchUser.setU_id("H120_0");
		
		//4 비교
		List<User> list = userDao.doSelectList(searchUser);
		assertThat(list.size(), is(5));
		
		for(User vo :list) { 
			LOG.debug(vo.getLevel().toString());
	    }


		//5
		try {
			this.userService.upgradeLevels(searchUser);
		} catch (Exception e) {
			e.printStackTrace();
		}		

		
		checkLevel(list.get(0), false);
		checkLevel(list.get(1), true);//등업대상,BASIC -> SILVER
		checkLevel(list.get(2), false);
		checkLevel(list.get(3), true);//등업대상,SILVER->GOLD
		checkLevel(list.get(4), false); 
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 예상등급 check,비교
	 * @param user(등업전)
	 * @param upgraded (등업여부) 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void checkLevel(User user, boolean upgraded) throws ClassNotFoundException, SQLException {
		//등업 처리 이후 데이터 
	    User upserUpdateLevel = this.userDao.doSelectOne(user.getU_id());
		
		if(upgraded == true) {
			assertThat(upserUpdateLevel.getLevel(), is(user.getLevel().nextLevel()));
		}else {
			assertThat(upserUpdateLevel.getLevel(), is(user.getLevel()));
		}
		
		
	}
	
	
	

}




