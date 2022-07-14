package kr.co.tj2;

import java.util.Scanner;

class UserInfo1{
	String userId;
	String userPassword;
	String userName;
	String userAddress;
	String phoneNumber;
	
	Scanner scan = new Scanner(System.in);
	
	public UserInfo1() {//오버로드(개발관점)
		this.userId = null;
		this.userPassword = null;
		this.userName = null;
		this.userAddress = null;
		this.phoneNumber=null;
	}
	public UserInfo1(String userId, String userPassword, String userName) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = null;
		this.phoneNumber=null;
	}
	public UserInfo1(String userId,String userPassword, String userName, String userAddress) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	public UserInfo1(String userId, String userPassword, String userName, String userAddress, String phoneNumber) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userAddress = userAddress;
		this.phoneNumber = phoneNumber;
	}
	public String setUserId() {
		System.out.println("아이디입력:");
		this.userId = scan.next();
		return userId;
	}
	public String setUserPassword() {
		System.out.println("암호입력:");
		this.userPassword = scan.next();
		return userPassword;
	}
	public String setUserName() {
		System.out.println("회원이름:");
		this.userName = scan.next();
		return userName;
	}
	public String setUserAddress() {
		System.out.println("주소입력:");
		this.userAddress = scan.next();
		return userAddress;
	}
	public String setPhoneNumber() {
		System.out.println("전화번호입력:");
		this.phoneNumber = scan.next();
		return phoneNumber;
	}
	public void userInfoDisplay(int number) {
		if(number==1) {
			System.out.println("아이디가 틀렸습니다.");
		}else if(number==2) {
			System.out.println("패스워드가 틀렸습니다.");
		}else {
			System.out.println("회원이십니다.");
			System.out.println(userId+":"+userPassword+":");
		}
			
	}
}

public class UserInfoTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		UserInfo1 userInfo1 = new UserInfo1();
		String userId = userInfo1.setUserId(); 
		String userPassword = userInfo1.setUserPassword();
		String userName = userInfo1.setUserName();
		String userAddress = userInfo1.setUserAddress();
		String phoneNumber = userInfo1.setPhoneNumber();
		UserInfo1 userInfo2 = new UserInfo1(userId,userPassword,userName,userAddress,phoneNumber);
		if(!userInfo2.userId.equals("java")) {
			userInfo2.userInfoDisplay(1);
		}else if(!userInfo2.userPassword.equals("1111")) {
			userInfo2.userInfoDisplay(2);
		}else {
			userInfo2.userInfoDisplay(3);
		}
	}

}
