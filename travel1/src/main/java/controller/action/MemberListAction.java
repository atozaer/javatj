package controller.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.common.JDBCUtil;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberVO> datas = dao.m_selectAll();
		req.setAttribute("memberList", datas);
		
		forward = new ActionForward();
		forward.setPath("memberList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
