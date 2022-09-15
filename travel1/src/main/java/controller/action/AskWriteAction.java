package controller.action;

import javax.servlet.ServletContext;

// 완료

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardVO;

public class AskWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		ServletContext sc=req.getServletContext();
		// JSP에서 application(내장객체,scope)을 이용하는 코드 -> sc객체
		
		String realFolder=sc.getRealPath("file"); // server.core 폴더명
		int maxSize=1024*1024*200; // 200mb
		String encType="UTF-8";
		MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		String fn=mr.getOriginalFileName("afile");//올리는 파일
		String frn=mr.getFilesystemName("afile");//저장된 파일
		System.out.println(fn+" | "+frn);
		
		AskboardDAO dao = new AskboardDAO();
		AskboardVO vo = new AskboardVO();
		
		vo.setMid(mr.getParameter("mid"));
		vo.setAtitle(mr.getParameter("atitle"));
		vo.setAcontent(mr.getParameter("acontent"));
		vo.setAfile(fn);
		
		req.setAttribute("askwrite", vo);
		req.setAttribute("afile", vo.getAfile());
		
		if(dao.a_insert(vo)) {
			forward = new ActionForward();
			forward.setPath("FileDupAction_Ask.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("문의 글 작성중에 문제발생!");
		}
		
		
		return forward;
	}

}
