package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardVO;
import model.vo.AskcommentVO;

public class A_comment_insertAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
ActionForward forward = null;
      

      
      AskboardVO avo = new AskboardVO();
      AskboardDAO adao = new AskboardDAO();
      AskcommentVO acvo = new AskcommentVO();
      
      acvo.setAnum(Integer.parseInt(req.getParameter("anum")));
      acvo.setMid(req.getParameter("mid"));
      acvo.setAccontent(req.getParameter("accontent"));
      
      req.setAttribute("anum", req.getParameter("anum"));            
      if(adao.a_insert_reply(acvo)) {
         forward = new ActionForward();
         forward.setPath("ask.do");
         forward.setRedirect(false);
      }else {
         throw new Exception("리뷰 댓글 작성 중에 문제발생!");
      }
      
      return forward;
   }

}