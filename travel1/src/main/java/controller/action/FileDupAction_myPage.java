package controller.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.DAO;
import model.dao.MemberDAO;
import model.vo.MemberVO;
import model.vo.VO;

public class FileDupAction_myPage implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		MemberDAO mdao=new MemberDAO();
		MemberVO mvo=new MemberVO();
		mvo.setMid(req.getParameter("mid"));
		mvo.setMpw(req.getParameter("mpw"));
		mvo=mdao.m_selectOne(mvo);
		
		String path="C:\\MOON\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\travel\\file";
		String mypath="C:\\MOON\\workspace\\travel\\src\\main\\webapp\\images";
		String filename=mvo.getMphoto();
		
		try {
			FileInputStream fis=new FileInputStream(path+"\\"+filename);//���� ����
			FileOutputStream fos=new FileOutputStream(mypath+"\\"+filename);//eclipse ws ����
			
			byte[] buff=new byte[3000];
			int len;
			int i=0;
			while((len=fis.read(buff))!=-1) {
				fos.write(buff, 0, len); // buff�� �����͸� len��ŭ write()
				i++;
			}
			System.out.println(i);
			
			fis.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("��������Ϸ�");
		}
		System.out.println("����1");
				
		if(filename!=null) {       
			HttpSession session=req.getSession();
			session.invalidate();			
			System.out.println("����2");
			
			session=req.getSession();
			session.setAttribute("member", mvo);
			
			System.out.println("����3");
	        forward=new ActionForward();
	        forward.setPath("mypage.do");
	        forward.setRedirect(false);
        }else {
        	throw new Exception("���� ���� �߿� �����߻�!");
        }
		
		return forward;
	}
	
}
