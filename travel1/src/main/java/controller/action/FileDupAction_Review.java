package controller.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.DAO;
import model.dao.MemberDAO;
import model.dao.ReviewboardDAO;
import model.vo.MemberVO;
import model.vo.ReviewboardVO;
import model.vo.VO;

public class FileDupAction_Review implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		
		
		
		String path="C:\\MOON\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\travel\\file";
		String mypath="C:\\MOON\\workspace\\travel\\src\\main\\webapp\\images";
		String filename=(String)req.getAttribute("rfile");
		
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
				
		if(filename!=null) {        
	        forward=new ActionForward();
	        forward.setPath("reviewBoard.do");
	        forward.setRedirect(false);
        }else {
        	throw new Exception("���� ���� �߿� �����߻�!");
        }
		
		return forward;
	}
	
}
