package controller.action;

import javax.servlet.ServletContext;

// �Ϸ�

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
		// JSP���� application(���尴ü,scope)�� �̿��ϴ� �ڵ� -> sc��ü
		
		String realFolder=sc.getRealPath("file"); // server.core ������
		int maxSize=1024*1024*200; // 200mb
		String encType="UTF-8";
		MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		String fn=mr.getOriginalFileName("afile");//�ø��� ����
		String frn=mr.getFilesystemName("afile");//����� ����
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
			throw new Exception("���� �� �ۼ��߿� �����߻�!");
		}
		
		
		return forward;
	}

}
