package controller.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.NewsboardDAO;
import model.vo.NewsboardVO;

public class NewsWriteAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

      ActionForward forward = null;
      
      ServletContext sc=req.getServletContext();
      // JSP에서 application(내장객체,scope)을 이용하는 코드 -> sc객체
      
      String realFolder=sc.getRealPath("file"); // server.core 폴더명
      int maxSize=1024*1024*200; // 200mb
      String encType="UTF-8";
      MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
      
      String fn=mr.getOriginalFileName("nphoto");//올리는 파일
      String frn=mr.getFilesystemName("nphoto");//저장된 파일
      System.out.println(fn+" | "+frn);
      
      NewsboardDAO dao = new NewsboardDAO();
      NewsboardVO vo = new NewsboardVO();
      
      vo.setNtitle(mr.getParameter("ntitle"));
      vo.setNcontent(mr.getParameter("ncontent"));
      vo.setNphoto(fn);
      
      req.setAttribute("file", fn);
      
      if(dao.n_insert(vo)) {
         forward = new ActionForward();
         forward.setPath("FileDupAction_News.do");
         forward.setRedirect(false);
      } else {
         throw new Exception("공지 글 작성 중에 문제발생!");
      }
      
            
      return forward;
   }

}