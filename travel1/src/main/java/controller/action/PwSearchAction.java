package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class PwSearchAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

      ActionForward forward = null;
      
      MemberVO vo = new MemberVO();
      MemberDAO dao = new MemberDAO();
      
      vo.setMid(req.getParameter("mid"));
      vo.setMname(req.getParameter("mname"));
      vo.setMmail(req.getParameter("mmail"));
      
      vo = dao.m_pwSearch(vo);
       System.out.println(vo);  
       PrintWriter out = res.getWriter();
      if(vo!=null) {
         // �������� �ؾ��ϳ�?
          String pw=vo.getMpw();         
          if(pw!=null) {         
            out.print("<script>alert('ã�� �н������ : "+pw+" �Դϴ�.'); location.href='login.jsp'</script>");
          }else {
             out.print("<script>alert('ã�� �н�����¾����ϴ�.'); location.href='login.jsp'</script>");
          }
      }
      
      return forward;
   }

}