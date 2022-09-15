package controller.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;


public class FileDupAction_Ask implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
			
		
		String path="C:\\MOON\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\travel\\file";
		String mypath="C:\\MOON\\workspace\\travel\\src\\main\\webapp\\images";
		String filename=(String)req.getAttribute("afile");
		
		try {
			FileInputStream fis=new FileInputStream(path+"\\"+filename);//서버 폴더
			FileOutputStream fos=new FileOutputStream(mypath+"\\"+filename);//eclipse ws 폴더
			
			byte[] buff=new byte[3000];
			int len;
			int i=0;
			while((len=fis.read(buff))!=-1) {
				fos.write(buff, 0, len); // buff의 데이터를 len만큼 write()
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
			System.out.println("사진복사완료");
		}
				
		if(filename!=null) {        
	        forward=new ActionForward();
	        forward.setPath("askBoard.do");
	        forward.setRedirect(false);
        }else {
        	throw new Exception("파일 복사 중에 문제발생!");
        }
		
		return forward;
	}
	
}
