package admin.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import admin.view.MainView;
import repository.AdminRepository;
import vo.AdminVO;

public abstract class AdminMainController {
	public boolean adminAppResult;
	public static Long sessionAdminNo;
	public static String sessionAdminName;
	
	MainView mainView = new MainView();
	AdminRepository adminRepository = new AdminRepository();
	AdminVO adminVO = new AdminVO();
	
	public void adminLogout() {
		sessionAdminNo = null;
		sessionAdminName = null;
	}
	
	public boolean adminAuthCheck() {
		boolean result = true;
		if (sessionAdminNo == null) {
			result = false;
		}
		
		return result;
	}
	
	public abstract void play();
	
	public void login() {
		List<String> loginInfo = mainView.loginInfo();
		AdminVO admin = adminRepository.selectByAdminIdAndPassword(loginInfo.get(0), loginInfo.get(1));
		if (admin != null) {
			sessionAdminNo = admin.getAdminNo();
			sessionAdminName = admin.getAdminName();
			mainView.printLoginSucess();
		}
		else {
			mainView.printLoginFail();
		}
	}
	
	public final void run() {
		while (true) {
			if (adminAuthCheck()) {
				mainView.printAdminPage();
				adminAppResult = true;
				play();
				if (!adminAppResult) {
					break;
				}
			}
			else {
				login();
			}
		}
	}
}
