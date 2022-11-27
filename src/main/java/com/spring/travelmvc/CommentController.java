package com.spring.travelmvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.travelmvc.impl.CommentDao;
import com.spring.travelmvc.impl.CommentDo;
import com.spring.travelmvc.impl.TravelDao;
import com.spring.travelmvc.impl.TravelDo;

@Controller
public class CommentController {
	
	@Autowired
	TravelDao travelDao;
	@Autowired
	CommentDao commentDao;
	
	@RequestMapping(value="/insertProcComment.do")
	public String insertProcComment(TravelDo tdo, CommentDo cdo, Model model) {
		commentDao.insertComment(tdo, cdo);
		
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/deleteComment.do")
	public String deleteComment(TravelDo tdo, CommentDo cdo, Model model) {
		commentDao.deleteComment(cdo);
		
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/modifyComment.do")
	public String modifyComment(TravelDo tdo, CommentDo cdo, Model model) {
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		model.addAttribute("cdo", cdo);
		
		return "getModifyCommentView";
	}
	
//	@RequestMapping(value="/modifyCommentProc.do")
//	public String modifyProcComment(TravelDo tdo, CommentDo cdo, Model model) {
//		
//	}
	
	
}
