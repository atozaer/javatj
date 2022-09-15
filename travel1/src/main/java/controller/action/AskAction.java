package controller.action;

import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardSet;
import model.vo.AskboardVO;

public class AskAction implements Action{
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

      ActionForward forward = null;
      
      
      AskboardDAO dao = new AskboardDAO();
      AskboardVO vo = new AskboardVO();
      
      
      vo.setAnum(Integer.parseInt(req.getParameter("anum")));
      
      ArrayList<AskboardSet> datas =dao.a_selectOne(vo);
      
      req.setAttribute("ask", datas);
      
      if(vo!=null) {
         
         forward = new ActionForward();
         forward.setPath("ask.jsp");
         forward.setRedirect(false);
      }

      return forward;
   }

}