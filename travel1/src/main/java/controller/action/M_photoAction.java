package controller.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.DAO;
import model.dao.MemberDAO;
import model.vo.MemberVO;
import model.vo.VO;

public class M_photoAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward=null;
		
		ServletContext sc=req.getServletContext();
        // JSP���� application(���尴ü,scope)�� �̿��ϴ� �ڵ� -> sc��ü
        
        String realFolder=sc.getRealPath("file"); // server.core ������
        int maxSize=1024*1024*200; // 200mb
        String encType="UTF-8";
        MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
        
        String fn=mr.getOriginalFileName("file");//�ø��� ����
        String frn=mr.getFilesystemName("file");//����� ����
        System.out.println(fn+" | "+frn);
        
        
        ///// get�� ���� parameter�� �ްų�,
        ///// parameter�� ���� ���ο� ������ �߰��ϴ� �ͺ���-
        ///// -mr��ü�� ���� ���޹޴°��� �� �������̶� �����˴ϴ�!��
        
        MemberDAO mdao=new MemberDAO();
        MemberVO mvo=new MemberVO();
        mvo.setMid(req.getParameter("mid"));        
        mvo.setMphoto(fn);
        
        req.setAttribute("mid", req.getAttribute("mid"));
        req.setAttribute("mpw", req.getAttribute("mpw"));
        
        VO vo=new VO();
        vo.setFn(fn);
        vo.setFrn(frn);
        
        if(mdao.m_mphotoUpdate(mvo)) {        
	        forward=new ActionForward();
	        forward.setPath("FileDupAction_myPage.do");
	        forward.setRedirect(false);
        }else {
        	throw new Exception("���� ���� �߿� �����߻�!");
        }
		
		return forward;
	}

}
