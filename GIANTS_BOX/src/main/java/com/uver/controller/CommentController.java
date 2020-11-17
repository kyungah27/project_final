package com.uver.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.service.CommentService;
import com.uver.service.LikeServiceImpl;
import com.uver.vo.CommentVO;
import com.uver.vo.LikeVO;

import net.minidev.json.JSONObject;

@Controller("CommentController")
public class CommentController {
	private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	CommentService commentService;

	@Autowired
	LikeServiceImpl likeService;

	public CommentController() {
	}

	public CommentController(CommentService commentservice) {
		this.commentService = commentservice;
	}

	@RequestMapping(value = "comment/comment_view.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String comment_view() {
		LOG.debug("comment_view");
		return "comment/comment_view";
	}

	/*
	 * // 댓글 리스트를 호출 할 때 맵핑 되는 메소드
	 * 
	 * @RequestMapping(value = "comment/list.do") public ModelAndView list(CommentVO
	 * commentVO, ModelAndView mav) { List<CommentVO> list =
	 * commentService.doSelectList(commentVO);
	 * mav.setViewName("comment/comment_view"); mav.addObject("list", list); return
	 * mav; }
	 */

	@RequestMapping(value = "comment/doInsert.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(CommentVO commentVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=commentVO=" + commentVO);
		LOG.debug("==================");

		int flag = this.commentService.doInsert(commentVO);
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

	@RequestMapping(value = "comment/doDelete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(CommentVO commentVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug(">>>>>>>>>>>>>>doDelete<<<<<<<<<<<<<");
		LOG.debug("=commentVO=" + commentVO);
		LOG.debug("==================");

		int flag = this.commentService.doDelete(commentVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리 합니다
		Message message = new Message();
		message.setMsgId(flag + "");

		if (flag == 1) {
			message.setMsgContents(commentVO.getContent() + " 이 삭제 되었습니다.");
		} else {
			message.setMsgContents(commentVO.getContent() + " 이 삭제 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;

	}

	@RequestMapping(value = "comment/doUpdate.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(CommentVO commentVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug(">>>>>>>>>>>>>>doUpdate<<<<<<<<<<<<<");
		LOG.debug("=commentVO=" + commentVO);
		LOG.debug("==================");

		int flag = this.commentService.doUpdate(commentVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리 합니다
		Message message = new Message();
		message.setMsgId(flag + "");

		if (flag == 1) {
			message.setMsgContents(commentVO.getContent() + " 이 수정 되었습니다.");
		} else {
			message.setMsgContents(commentVO.getContent() + " 이 수정 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}

	@RequestMapping(value = "comment/doSelectList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectList(CommentVO commentVO) throws ClassNotFoundException, SQLException, IOException {
		LOG.debug("===doSelectList=====");
		LOG.debug("===seq=====" + commentVO.getSeq());
		LOG.debug("===div===" + commentVO.getDiv());

		List<CommentVO> list = commentService.doSelectList(commentVO);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		// res.setContentType("text/html; charset=UTF-8");
		LOG.debug("json" + json);
		return json;
	}

	@RequestMapping(value = "comment/like.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String like(int commentSeq, HttpSession session) {
		LOG.debug(">>>>>>>>>>>>>>like<<<<<<<<<<<<<");
		// int memberSeq = (Integer) session.getAttribute("memberSeq");
		JSONObject obj = new JSONObject();

		LikeVO likeVO = new LikeVO();
		int memberSeq = likeVO.getMemberSeq();
		likeVO.setCommentSeq(commentSeq);
		// 세션으로 로그인한 사용자로 변경
		likeVO.setMemberSeq(141);

		LikeVO outVO = likeService.read(likeVO);

		// likeVO가 null(0) 이면 좋아요에 인서트.
		CommentVO commentVO = new CommentVO();
		if (null == outVO) {
			// 좋아요 인서트.
			likeVO.setLikeCheck(1);
			likeService.doInsert(likeVO);

			// 댓글 좋아요 카운트 증가.
			commentVO = commentService.doSelectOne(commentSeq);
			commentVO.setLikeCnt(commentVO.getLikeCnt() + 1);
			commentService.likeCntUp(commentVO);
			obj.put("likeCheck", 1);

		} else {
			// 널이 아니면. 좋아요 수 감소.
			commentVO = commentService.doSelectOne(commentSeq);
			commentVO.setLikeCnt(commentVO.getLikeCnt() - 1);
			commentService.likeCntDown(commentVO);
			//likeService.deleteMemberSeq(outVO.getMemberSeq());
			likeService.deleteCommentSeq(outVO.getCommentSeq());
			obj.put("likeCheck", 0);

		}
		// 좋아요 수를 리턴.
		obj.put("likeCnt", commentVO.getLikeCnt());

		return obj.toJSONString();
	}
// 업데이트 테스트 못짜겠고
}
