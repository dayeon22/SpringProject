package com.spring.travelmvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.travelmvc.impl.MemberDao;
import com.spring.travelmvc.impl.MemberDo;
import com.spring.travelmvc.util.ScriptUtil;

@Controller
public class MemberController {
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value="/getLogin.do")
	public String getLogin() {
		return "getLoginView";
	}
	
	@RequestMapping(value="/login.do")
	public String login(String id, String password, HttpServletResponse response, HttpSession session) throws IOException {
		ArrayList<MemberDo> dbList = memberDao.getMemberById(id);
		if (dbList.isEmpty() || !dbList.get(0).getPassword().equals(password)) {
			ScriptUtil.alertAndBackPage(response, "아이디나 비밀번호가 잘못되었습니다.");
		} else {
			session.setAttribute("sessionId", id);
		}
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/getJoin.do")
	public String getJoin() {
		return "getJoinView";
	}
	
	@RequestMapping(value="/join.do")
	public String join(MemberDo mdo, String passwordConfirm, HttpServletResponse response) throws IOException {
		
		System.out.println(mdo.getId());
		System.out.println(mdo.getPassword());
		System.out.println(passwordConfirm);
		System.out.println(mdo.getName());
		System.out.println(mdo.getAge());
		System.out.println(mdo.getGender());
		
		ArrayList<MemberDo> dbList = memberDao.getMemberById(mdo.getId());
		if (!dbList.isEmpty()) {
			ScriptUtil.alertAndBackPage(response, "이미 존재하는 회원입니다.");
		} else {
			memberDao.insertMember(mdo);
		}
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:getTravelList.do";
	}
	
	@RequestMapping(value="/unregister.do")
	public String unregister(HttpSession session) {
		memberDao.deleteMember((String)session.getAttribute("sessionId"));
		session.invalidate();
		return "redirect:getTravelList.do";
	}
}
