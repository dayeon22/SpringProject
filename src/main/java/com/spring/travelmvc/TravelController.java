package com.spring.travelmvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.travelmvc.impl.CommentDao;
import com.spring.travelmvc.impl.CommentDo;
import com.spring.travelmvc.impl.TravelDao;
import com.spring.travelmvc.impl.TravelDo;
import com.spring.travelmvc.util.ScriptUtil;

@Controller
public class TravelController {
	
	@Autowired
	TravelDao travelDao;
	@Autowired
	CommentDao commentDao;
	
	@RequestMapping(value="/insertTravel.do")
	public String insertTravel() {
		return "getInsertView";
	}
	
	@RequestMapping(value="/insertProcTravel.do")
	public String insertProcTravel(TravelDo tdo) {
		
		System.out.println(tdo.getTitle());
		System.out.println(tdo.getWriter());
		System.out.println(tdo.getContent());
		travelDao.insertTravel(tdo);
		
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/getTravel.do")
	public String getTravel(TravelDo tdo, Model model) {
		TravelDo travel = travelDao.getTravel(tdo);
		ArrayList<CommentDo> cList = commentDao.getCommentList(tdo);
		model.addAttribute("travel", travel);
		model.addAttribute("cList", cList);
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/getTravelList.do")
	public String getTravelList(TravelDo tdo, Model model) {
		ArrayList<TravelDo> tlist = travelDao.getTravelList();
		model.addAttribute("tList", tlist);
		
		return "getTravelListView";
	}
	
	@RequestMapping(value="/modifyTravel.do")
	public String modifyTravel(TravelDo tdo, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		TravelDo travel = travelDao.getTravel(tdo);
		model.addAttribute("travel", travel);
		TravelDo dbTdo = travelDao.getTravel(tdo);
		String sessionId = (String)session.getAttribute("sessionId");
		if (sessionId == null) {
			ScriptUtil.alertAndBackPage(response,  "로그인 후 이용해 주세요.");
		} else if (!sessionId.equals(dbTdo.getWriter())) {
			ScriptUtil.alertAndBackPage(response,  "타인의 글은 삭제할 수 없습니다.");
		}
		
		return "getModifyView";
	}
	
	@RequestMapping(value="/modifyProcTravel.do")
	public String modifyProcTravel(TravelDo tdo, Model model) {
		travelDao.updateTravel(tdo);
		
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/deleteTravel.do")
	public String deleteBTravel(TravelDo tdo, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		TravelDo dbTdo = travelDao.getTravel(tdo);
		String sessionId = (String)session.getAttribute("sessionId");
		if (sessionId == null) {
			ScriptUtil.alertAndBackPage(response,  "로그인 후 이용해 주세요.");
		} else if (!sessionId.equals(dbTdo.getWriter())) {
			ScriptUtil.alertAndBackPage(response,  "타인의 글은 삭제할 수 없습니다.");
		} else {
			travelDao.deleteTravel(tdo);
		}
		
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/searchTravelList.do")
	public String searchTravelList(
			@RequestParam(value="searchCon") String searchCon,
			@RequestParam(value="searchKey") String searchKey,
			Model model) {

		ArrayList<TravelDo> tList = travelDao.searchTravelList(searchCon, searchKey);
		model.addAttribute("tList", tList);
		
		return "getTravelListView";
	}
}
