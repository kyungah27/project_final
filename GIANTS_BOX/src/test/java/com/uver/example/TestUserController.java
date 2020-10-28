package com.uver.example;

import static com.uver.example.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.uver.example.UserServiceImpl.MIN_RECOMMEND_FOR_SILVER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                               "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
})
public class TestUserController {
	private static final Logger LOG = LoggerFactory.getLogger(TestUserController.class);

	@Autowired
	WebApplicationContext  context;
	
	List<User>  users;
	
	@Autowired
	UserService  userService;
	
	//브라우저 대신 Mock
	MockMvc  mockMvc;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("-------------------------------------");
		LOG.debug("setUp(): ");
		users = Arrays.asList(
				 new User("H120_01","전현정_01","1234",Level.BASIC,MIN_LOGCOUNT_FOR_SILVER-1,0,"skyblueninz@naver.com","")//BASIC
				,new User("H120_02","전현정_02","1234",Level.BASIC,MIN_LOGCOUNT_FOR_SILVER,0,"skyblueninz@naver.com","")//BASIC ->SILVER
				,new User("H120_03","전현정_03","1234",Level.SILVER,60,MIN_RECOMMEND_FOR_SILVER-1,"skyblueninz@naver.com","")//SILVER
				,new User("H120_04","전현정_04","1234",Level.SILVER,70,MIN_RECOMMEND_FOR_SILVER,"skyblueninz@naver.com","")//SILVER->GOLD
				,new User("H120_05","전현정_05","1234",Level.GOLD,99,MIN_RECOMMEND_FOR_SILVER+3,"skyblueninz@naver.com","")//GOLD
				);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.debug("mockMvc: "+mockMvc);
		assertThat(mockMvc, is(notNullValue()));
		LOG.debug("-------------------------------------");
	}

	@After
	public void tearDown() throws Exception {}
	
	@Test
	@Ignore
	public void test() {
		System.out.println("----test()----");
	}
	
	@Test
	@Ignore
	public void beans() {
		LOG.debug("---------------------------");
		LOG.debug("webApplicationContext: "+context);
		LOG.debug("userService: "+userService);
		LOG.debug("---------------------------");
		
		assertThat(context, is(notNullValue()));
		assertThat(userService, is(notNullValue()));
	}
	
	@Test
	@Ignore
	public void addAndGet() throws Exception {
		doDelete(users.get(0));
		doDelete(users.get(1));
		doDelete(users.get(2));
		
		doInsert(users.get(0));
		doInsert(users.get(1));
		doInsert(users.get(2));
	}
	
	
	
	@Test
	@Ignore
	public void doSelectOne() throws Exception {
		MockHttpServletRequestBuilder createMessage
	        =MockMvcRequestBuilders.get("/user/doSelectOne.do")
							        .param("u_id", users.get(0).getU_id());
		
		ResultActions resultActions = mockMvc.perform(createMessage)
					                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
					                .andExpect(status().is2xxSuccessful())
					                .andExpect(jsonPath("$.msgId", is(users.get(0).getU_id())));
                
       String result = resultActions.andDo(print())
    		   			.andReturn()
       					.getResponse().getContentAsString();
       
       LOG.debug("result : "+ result);
	}
	
	
	
	
	

	
	@Test
	@Ignore
	public void userViewPostJson() throws Exception {
		//url,param set
		MockHttpServletRequestBuilder  createMessage
		                            =MockMvcRequestBuilders.post("/user_view_json.do")
		                            .param("u_id", users.get(0).getU_id())
		                            .param("name", users.get(0).getName())
		                            .param("passwd", users.get(0).getPasswd());
		//"u_id":"H120_01"
		ResultActions resultActions = mockMvc.perform(createMessage)
				                      .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				                      .andExpect(status().is2xxSuccessful())
				                      //.andExpect(MockMvcResultMatchers.jsonPath("$.name", is(users.get(0).getName())))
				                      ;
		
				                      ;
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
		LOG.debug("===========================");
		LOG.debug("=result="+result);
		LOG.debug("===========================");			
		
	}
	
	
	@Test
	@Ignore
	public void userViewPost() throws Exception {
//		String uId = req.getParameter("u_id");
//		String name = req.getParameter("name");
//		String passwd = req.getParameter("passwd");
		
		//url 호출,param전달
		MockHttpServletRequestBuilder  createMessage 
		                              = MockMvcRequestBuilders.post("/user_view.do")
		                              .param("u_id", users.get(0).getU_id())
		                              .param("name", users.get(0).getName())
		                              .param("passwd", users.get(0).getPasswd())
		                              ;
		ResultActions resultActions = this.mockMvc.perform(createMessage)
				                      .andExpect(status().isOk());
		
		String result = resultActions.andDo(print())
				        .andReturn()
				        .getResponse().getContentType()
		 		        ;
		LOG.debug("===========================");
		LOG.debug("=result="+result);
		LOG.debug("===========================");		
	}
	
	
	
	
	public void doInsert(User user) throws Exception {
		MockHttpServletRequestBuilder  createMessage
		                            =MockMvcRequestBuilders.post("/user/doInsert.do")
		                            .param("u_id", user.getU_id())
		                            .param("name", user.getName())
		                            .param("passwd", user.getPasswd())
									.param("level", user.getLevel()+"")
									.param("login", user.getLogin()+"")
									.param("recommend", user.getRecommend()+"")
									.param("mail", user.getMail()+"")
									;
		
		//"u_id":"H120_01"
		ResultActions resultActions = mockMvc.perform(createMessage)
				                      .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				                      .andExpect(status().is2xxSuccessful())
				                      .andExpect(jsonPath("$.msgId", is("1")));
				                      ;
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
		LOG.debug("===========================");
		LOG.debug("=result="+result);
		LOG.debug("===========================");		
	}
	
	public void doDelete(User user) throws Exception {
		MockHttpServletRequestBuilder createMessage
	        =MockMvcRequestBuilders.get("/user/doDelete.do")
							        .param("u_id", user.getU_id());
		
		ResultActions resultActions = mockMvc.perform(createMessage)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.msgId", is("1")));
                
       String result = resultActions.andDo(print())
    		   			.andReturn() //mvc result return
       					.getResponse().getContentAsString();
       
       LOG.debug("result : "+ result);
		
	}
	
	
	

}
