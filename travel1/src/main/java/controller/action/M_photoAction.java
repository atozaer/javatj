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
        // JSP에서 application(내장객체,scope)을 이용하는 코드 -> sc객체
        
        String realFolder=sc.getRealPath("file"); // server.core 폴더명
        int maxSize=1024*1024*200; // 200mb
        String encType="UTF-8";
        MultipartRequest mr=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
        
        String fn=mr.getOriginalFileName("file");//올리는 파일
        String frn=mr.getFilesystemName("file");//저장된 파일
        System.out.println(fn+" | "+frn);
        
        
        ///// get을 통해 parameter를 받거나,
        ///// parameter를 위한 새로운 로직을 추가하는 것보다-
        ///// -mr객체를 통해 전달받는것이 더 나을것이라 생각됩니다!★
        
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
        	throw new Exception("사진 변경 중에 문제발생!");
        }
		
		return forward;
	}

}
