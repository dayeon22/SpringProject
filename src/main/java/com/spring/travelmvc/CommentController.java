package com.spring.travelmvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.travelmvc.impl.CommentDao;
import com.spring.travelmvc.impl.CommentDo;
import com.spring.travelmvc.impl.TravelDao;
import com.spring.travelmvc.impl.TravelDo;
import com.spring.travelmvc.util.ScriptUtil;

@Controller
public class CommentController {
	
	@Autowired
	TravelDao travelDao;
	@Autowired
	CommentDao commentDao;
	
	@RequestMapping(value="/insertProcComment.do")
	public String insertProcComment(TravelDo tdo, CommentDo cdo, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		String sessionId = (String)session.getAttribute("sessionId");
		if (sessionId == null) {
			ScriptUtil.alertAndBackPage(response,  "로그인 후 이용해 주세요.");
		} else {
			cdo.setWriter(sessionId);
			commentDao.insertComment(tdo, cdo);
		}		
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/deleteComment.do")
	public String deleteComment(TravelDo tdo, CommentDo cdo, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		String commentId = null;
		for (CommentDo comment : cList) {
			if (comment.getCommentSeq() == cdo.getCommentSeq()) {
				commentId = comment.getWriter();
			}
		}
		String sessionId = (String)session.getAttribute("sessionId");
		
		if (sessionId == null) {
			ScriptUtil.alertAndBackPage(response,  "로그인 후 이용해 주세요.");
		} else if (!sessionId.equals(commentId)) {
			ScriptUtil.alertAndBackPage(response,  "타인의 글은 삭제할 수 없습니다.");
		} else {
			commentDao.deleteComment(cdo);
			cList = commentDao.getCommentList(tdo);
			model.addAttribute("travel", travel);
			model.addAttribute("cList", cList);
		}
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/modifyComment.do")
	public String modifyComment(TravelDo tdo, CommentDo cdo, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		model.addAttribute("cdo", cdo);
		
		String commentId = null;
		for (CommentDo comment : cList) {
			if (comment.getCommentSeq() == cdo.getCommentSeq()) {
				commentId = comment.getWriter();
			}
		}
		String sessionId = (String)session.getAttribute("sessionId");
		
		if (sessionId == null) {
			ScriptUtil.alertAndBackPage(response,  "로그인 후 이용해 주세요.");
		} else if (!sessionId.equals(commentId)) {
			ScriptUtil.alertAndBackPage(response,  "타인의 글은 수정할 수 없습니다.");
		}
		return "getModifyCommentView";
	}
	
	@RequestMapping(value="/modifyProcComment.do")
	public String modifyProcComment(TravelDo tdo, CommentDo cdo, Model model) {
		commentDao.updateComment(cdo);
		
		System.out.println(tdo.getSeq());
		
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		
		return "getTravelView";
	}
	
}
