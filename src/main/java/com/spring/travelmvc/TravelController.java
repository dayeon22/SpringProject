package com.spring.travelmvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.travelmvc.impl.TravelDao;
import com.spring.travelmvc.impl.TravelDo;

@Controller
public class TravelController {
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value="/insertTravel.do")
	public String insertTravel() {
		return "getInsertView";
	}
	
	@RequestMapping(value="/insertProcTravel.do")
	public String insertProcTravel(TravelDo tdo) {
		System.out.println("title: " + tdo.getTitle());
		System.out.println("writer: " + tdo.getWriter());
		System.out.println("content: " + tdo.getContent());
		travelDao.insertTravel(tdo);
		
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/getTravel.do")
	public String getTravel(TravelDo tdo, Model model) {
		TravelDo travel = travelDao.getTravel(tdo);
		model.addAttribute("travel", travel);
		
		return "getTravelView";
	}
	
	@RequestMapping(value="/getTravelList.do")
	public String getTravelList(TravelDo tdo, Model model) {
		ArrayList<TravelDo> tlist = travelDao.getTravelList();
		model.addAttribute("tList", tlist);
		
		return "getTravelListView";
	}
	
	@RequestMapping(value="/modifyTravel.do")
	public String modifyTravel(TravelDo tdo, Model model) {
		TravelDo travel = travelDao.getTravel(tdo);
		model.addAttribute("travel", travel);
		
		return "getModifyView";
	}
	
	@RequestMapping(value="/modifyProcTravel.do")
	public String modifyProcTravel(TravelDo tdo, Model model) {
		travelDao.updateTravel(tdo);
		model.addAttribute(tdo);
		
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/deleteTravel.do")
	public String deleteBTravel(TravelDo tdo, Model model) {
		travelDao.deleteTravel(tdo);
		
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
