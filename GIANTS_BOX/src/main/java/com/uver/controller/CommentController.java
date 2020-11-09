package com.uver.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.service.CommentService;
import com.uver.vo.CommentVO;

@Controller("CommentController")
public class CommentController {
	private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	CommentService commentservice;

	public CommentController() {
	}

	public CommentController(CommentService commentservice) {
		this.commentservice = commentservice;
	}

	@RequestMapping(value = "comment/doInsert.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(CommentVO commentVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=commentVO=" + commentVO);
		LOG.debug("==================");

		int flag = this.commentservice.doInsert(commentVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리 합니다
		Message message = new Message();
		message.setMsgId(flag + "");

		if (flag == 1) {
			message.setMsgContents(commentVO.getContent() + " 이 등록 되었습니다.");
		} else {
			message.setMsgContents(commentVO.getContent() + " 이 등록 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
}
