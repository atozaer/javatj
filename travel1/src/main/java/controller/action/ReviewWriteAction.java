package controller.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardVO;

public class ReviewWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
			
		ServletContext sc=req.getServletContext();
		// JSP에서 application(내장객체,scope)을 이용하는 코드 -> sc객체
		
		String realFolder=sc.getRealPath("file"); // server.core 폴더명
		int maxSize=1024*1024*200; // 200mb
		String encType="UTF-8";
		MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		String fn=mr.getOriginalFileName("rfile");//올리는 파일
		String frn=mr.getFilesystemName("rfile");//저장된 파일
		System.out.println(fn+" | "+frn);
		
        ReviewboardVO vo = new ReviewboardVO();
        ReviewboardDAO dao = new ReviewboardDAO();
        
        vo.setRtitle(mr.getParameter("rtitle"));
        vo.setMid(mr.getParameter("mid"));
        vo.setRcontent(mr.getParameter("rcontent"));
        vo.setRdate(mr.getParameter("rdate"));
        vo.setRfile(fn);
        vo.setRaddress(mr.getParameter("raddress"));
        
        System.out.println(vo);
        
        req.setAttribute("rfile", fn);
				
		if(dao.r_insert(vo)) {//db에 review 생성.
			
			forward = new ActionForward();
			forward.setPath("FileDupAction_Review.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("리뷰 글 작성 중에 문제발생!");
		}
		
		
		return forward;
	}

}
