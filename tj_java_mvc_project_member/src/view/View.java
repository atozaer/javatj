package view;

import java.text.SimpleDateFormat;

import controller.MainController;

public abstract class View {
	protected final String listTitle;
	protected final String listString;
	protected final String listSplit = "================================================================================================";
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String menuCode;
	
	public View(String listTitle, String listString) {
		this.listTitle = listTitle;
		this.listString = listString;
	}
	
	public abstract void menuSelector();  
	
	public abstract void menuReSelector();
	
	protected void showListHeader() {
		System.out.println(listSplit);
		System.out.println(listTitle);
		System.out.println(listSplit);
	}
	
	protected void showListFooter() {
		System.out.println(listSplit);
	}
	
	protected void showSearchMessage(String msg) {
		System.out.printf("검색할 %s을(를) 입력해 주세요\n", msg);
	}
	
	protected String getSearchStringMessage(String msg) {
		showSearchMessage(msg);
		return MainController.sc.next();
	}
	
	protected int getSearchIntMessage(String msg) {
		showSearchMessage(msg);
		return MainController.sc.nextInt();
	}
}
