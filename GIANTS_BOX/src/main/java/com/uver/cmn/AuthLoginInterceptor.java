package com.uver.cmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Controller호출 전 Session유무 check
     * session이 없으면 Login page로 이동.
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =  request.getSession();
		LOG.debug("***************************");
		LOG.debug("*preHandle*");
		LOG.debug("***************************");
		Object obj = session.getAttribute("user");
		if(obj == null) {
			//로그인이 않되어 있으면 로그인 페이지로 이동.
			response.sendRedirect(request.getContextPath()+"/login.do");
			return false;
		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOG.debug("***************************");
		LOG.debug("*postHandle*");
		LOG.debug("***************************");
		super.postHandle(request, response, handler, modelAndView);
	}

}
