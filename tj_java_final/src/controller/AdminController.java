package controller;

import admin.controller.AdminMainController;
import admin.controller.MemberController;
import admin.controller.OrderController;
import admin.controller.ProductController;
import admin.view.MainView;

public class AdminController extends Controller{

	@Override
	void selectMenu() {
		controllerResult = true;
		
		AdminMainController adminMainController = new AdminMainController() {
			MainView mainView = new MainView();
			@Override
			public void play() {
				AdminMainController adminAppController = null;
				String menuCode = mainView.menuSelector();
				if (menuCode.equals("m")) { 
					adminAppController = new MemberController();
				}
				else if (menuCode.equals("p")) {
					adminAppController = new ProductController();
				}
				else if (menuCode.equals("o")) {
					adminAppController = new OrderController();
				}
				else {
					adminLogout();
					adminAppResult = false;
					return;
				}
				
				adminAppController.run();
			}
		};
		
		adminMainController.run();
		
		controllerResult = false;
	}

}
