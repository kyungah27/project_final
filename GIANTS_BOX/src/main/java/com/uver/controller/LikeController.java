package com.uver.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uver.service.CommentService;
import com.uver.service.LikeServcie;
import com.uver.vo.CommentVO;
import com.uver.vo.LikeVO;

import net.minidev.json.JSONObject;

@Controller("LikeController")
public class LikeController {
	private static final Logger LOG = LoggerFactory.getLogger(LikeController.class);

	@Autowired
	LikeServcie likeServcie;

	@Autowired
	CommentService commentService;

	public LikeController() {
	}

	public LikeController(LikeServcie likeServcie) {
		super();
		this.likeServcie = likeServcie;
	}

	@ResponseBody
	@RequestMapping(value = "/like/like.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String like(int commentSeq, HttpSession session) {
		int memberSeq = (Integer) session.getAttribute("memberSeq");
		JSONObject obj = new JSONObject();
		
		
		LikeVO likeVO = new LikeVO(0, commentSeq, memberSeq, 1);
		
		likeServcie.doInsert(likeVO);
		
		
		
		
		
		
		/*
		 * hashMap.put("commentSeq", commentSeq); hashMap.put("memberSeq", memberSeq);
		 * LikeVO likeVO = likeServcie.read(likeVO);
		 * 
		 * CommentVO commentVO = commentService.read(commentSeq); int likeCnt =
		 * commentVO.getLike_cnt(); // 게시판의 좋아요 카운트 int likeCheck = 0; likeCheck =
		 * likeVO.getLikeCheck(); // 좋아요 체크 값
		 * 
		 * if (likeServcie.countLike(likeVO) == 0) { likeServcie.doInsert(likeVO); }
		 * 
		 * if (likeCheck == 0) { msgs.add("좋아요!"); likeServcie.likeCheck(likeVO);
		 * likeCheck++; likeCnt++; commentService.like_cnt_up(commentSeq); // 좋아요 갯수 증가
		 * } else { msgs.add("좋아요 취소"); likeServcie.likeCheckCancel(likeVO);
		 * likeCheck--; likeCnt--; commentService.like_cnt_down(commentSeq); // 좋아요 갯수
		 * 감소 } obj.put("commentSeq", likeVO.getCommentSeq()); obj.put("likeCheck",
		 * likeCheck); obj.put("likeCnt", likeCnt); obj.put("msg", msgs);
		 */

		return obj.toJSONString();
	}
}
