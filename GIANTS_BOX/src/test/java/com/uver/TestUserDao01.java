package com.uver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.uver.user.dao.Level;
import com.uver.user.dao.User;
import com.uver.user.dao.UserDaoImpl;

//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestUserDao01 {  
    Logger  LOG = LoggerFactory.getLogger(this.getClass());
    
    @Autowired //테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
    WebApplicationContext  context ;
    
    @Autowired
    UserDaoImpl  userDao;
    
    //픽스처
    User  user01;
    User  user02;
    User  user03;
    
	@Before
	public void setUp() throws Exception {
    	
    	LOG.debug("** setup() **");
    	LOG.debug("***************************************");
    	LOG.debug("** context **"+context);
    	LOG.debug("** userDao **"+userDao);
    	
    	user01=new User("H120_01","전현정_01","1234",Level.BASIC,1,0,"skyblueninz@naver.com","");//BASIC
    	user02=new User("H120_02","전현정_02","1234",Level.SILVER,51,10,"skyblueninz@naver.com","");//SILVER
    	user03=new User("H120_03","전현정_03","1234",Level.GOLD,55,31,"skyblueninz@naver.com","");//GOLD
	}
	
	
	

	@After
	public void tearDown() throws Exception {	
		LOG.debug("** tearDown() **");
		LOG.debug("***************************************");
	}

    
	@Test
	@Ignore
    public void test() {
    	System.out.println("JUnit test");
    }
    
	
	
	
	
	
	 //timeout 허용범위 시간을 측정.
    //@Test(timeout = 19000)
    @Test
//    @Ignore
    public void addAndGet() throws ClassNotFoundException, SQLException {
    	
    	//1.삭제
    	userDao.doDelete(user01);
    	userDao.doDelete(user02);
    	userDao.doDelete(user03);
    	
    	//2.추가
    	int flag = userDao.doInsert(user01);
    	//2.1.등록 성공 Check
    	assertThat(flag, is(1));
    	
    	User   cntUser=new User();
    	cntUser.setU_id("H120_0");
    	//2.2.등록 건수 조회
    	int cnt = userDao.count(cntUser);
    	assertThat(cnt, is(1));
    	
    	flag = userDao.doInsert(user02);
    	assertThat(flag, is(1));
    	
    	cnt = userDao.count(cntUser);
    	assertThat(cnt, is(2));
    	
    	flag = userDao.doInsert(user03);
    	assertThat(flag, is(1));
    	
    	cnt = userDao.count(cntUser);
    	assertThat(cnt, is(3));    	
    	
    	//3.단건조회
    	User  vsUser01 = userDao.doSelectOne(user01.getU_id());
    	User  vsUser02 = userDao.doSelectOne(user02.getU_id());
    	User  vsUser03 = userDao.doSelectOne(user03.getU_id());
    	//3.1.조회 데이터 검증
    	checkUser(user01,vsUser01);
    	checkUser(user02,vsUser02);
    	checkUser(user03,vsUser03);
    }
  
	
	
	
	
	
    
    @Test
    @Ignore
    public void doUpdate() throws ClassNotFoundException, SQLException {
    	//1.기존데이터 삭제
    	userDao.doDelete(user01);
    	userDao.doDelete(user02);
    	userDao.doDelete(user03);
    	
    	//2.단건입력
    	int flag =userDao.doInsert(user01);
    	assertThat(1, is(1));
    	//3.수정:이름,비번 수정
		//user01=new User("H10_01","강사_01","1234",Level.BASIC,1,0,"jamesol@paran.com","");//BASIC
    	user01.setName(user01.getName()+"_U");
    	user01.setPasswd(user01.getPasswd()+"_U");
    	user01.setLevel(Level.SILVER);
    	user01.setLogin(111);
    	user01.setRecommend(1);
    	user01.setMail(user01.getMail()+"_U");
    	
    	flag = userDao.doUpdate(user01);
    	assertThat(1, is(1));
    	//4.단건조회
    	//cntUser.setU_id("H10_0");
    	User vsUser = userDao.doSelectOne(user01.getU_id());
    	
    	//5.수정과 단건조회 비교.
    	checkUser(user01, vsUser);
    	
    }
    
    
    @Test(expected = EmptyResultDataAccessException.class)
    @Ignore
    public void getFailure() throws ClassNotFoundException, SQLException {
    	LOG.debug("=================");
    	LOG.debug("=getFailure()=");
    	LOG.debug("=================");
    	//--------------------------------------------//
    	//기존데이터 삭제.                               //
    	//--------------------------------------------//    	
    	userDao.doDelete(user01);
    	userDao.doDelete(user02);
    	userDao.doDelete(user03);
    	
    	
    	//업는 데이터 조회
    	userDao.doSelectOne("unknown_id");
    	
    }
    
    @Test
    @Ignore
    public void getAll() throws ClassNotFoundException, SQLException{
    	//-----------------------------------
    	//기존데이터 삭제
    	//-----------------------------------
    	userDao.doDelete(user01);
    	userDao.doDelete(user02);
    	userDao.doDelete(user03);
    	
    	//-----------------------------------
    	//데이터 입력
    	//-----------------------------------  
    	userDao.doInsert(user01);
    	userDao.doInsert(user02);
    	userDao.doInsert(user03);
    	//-----------------------------------
    	//전체 데이터 조회: 건수 3건 확인 
    	//-----------------------------------    
    	User   cntUser=new User();
    	cntUser.setU_id("H120_0");
    	
    	List<User> list = userDao.doSelectList(cntUser);
    	assertThat(list.size(), is(3));
    	//-----------------------------------
    	//입력데이터와 비교 
    	//-----------------------------------     	
    	checkUser(user01,list.get(0));
    	checkUser(user02,list.get(1));
    	checkUser(user03,list.get(2));
    }
    
    
   
    
    
    
    
    
    
    private void checkUser(User orgUser, User vsUser) {
    	assertThat(orgUser.getU_id(), is(vsUser.getU_id()));
    	assertThat(orgUser.getName(), is(vsUser.getName()));
    	assertThat(orgUser.getPasswd(), is(vsUser.getPasswd()));
    	
//		outVO.setLevel(Level.valueOf(rs.getInt("u_level")) );
//		outVO.setLogin(rs.getInt("login"));
//		outVO.setRecommend(rs.getInt("recommend"));
//		outVO.setMail(rs.getString("mail"));
//		outVO.setRegDt(rs.getString("reg_dt"));
    	
    	assertThat(orgUser.getLevel(),is(vsUser.getLevel()));
    	assertThat(orgUser.getLogin(),is(vsUser.getLogin()));
    	assertThat(orgUser.getRecommend(),is(vsUser.getRecommend()));
    	assertThat(orgUser.getMail(),is(vsUser.getMail()));
    	
    }
}

