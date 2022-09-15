package controller.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class IdSearchAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

      ActionForward forward = null;
      
      MemberVO vo = new MemberVO();
      MemberDAO dao = new MemberDAO();
      
      vo.setMname(req.getParameter("mname"));
      vo.setMmail(req.getParameter("mmail"));
      
      vo = dao.m_idSearch(vo);
      System.out.println(vo); 
      PrintWriter out=res.getWriter();
      if(vo!=null) {
         // �������� �ؾ��ϳ�?
         String id=vo.getMid();         
          
         if(id!=null) {
            out.print("<script>alert('ã�� ���̵�� : "+id+" �Դϴ�.'); location.href='login.jsp'</script>");
         }            
      }else {
         out.print("<script>alert('ã�� ���̵�� �����ϴ�.'); location.href='login.jsp'</script>");
      }
      return forward;
   }
  

}