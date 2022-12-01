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
			ScriptUtil.alertAndBackPage(response, "���̵� ��й�ȣ�� �߸��Ǿ����ϴ�.");
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
		ArrayList<MemberDo> dbList = memberDao.getMemberById(mdo.getId());
		if (!dbList.isEmpty()) {
			ScriptUtil.alertAndBackPage(response,  "�̹� �����ϴ� ȸ���Դϴ�.");
		} else if (!mdo.getPassword().contentEquals(passwordConfirm)) {
			ScriptUtil.alertAndBackPage(response,  "��й�ȣ�� Ȯ���� �ּ���."); // �̰� getJoinView.jsp���� �ϴ°� ����
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
}
