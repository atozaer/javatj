//package kr.co.tj2;
//
//import java.util.Scanner;
//
//class PersonInfo {
//	int personHeight;
//	double personWeight;
//	String personName;
//	int personAge;
//
//	Scanner scan = new Scanner(System.in);
//
//	public PersonInfo() {}
//	public PersonInfo(int personHeight, double personWeight, String personName, int personAge) {
//		this.personHeight = personHeight;
//		this.personWeight = personWeight;
//		this.personName = personName;
//		this.personAge = personAge;
//	}
//
//	public int setPersonHeight() {
//		System.out.println("키 입력:");
//		this.personHeight = scan.nextInt();
//		return personHeight;
//	}
//
//	public double setPersonWeight() {
//		System.out.println("몸무게 입력:");
//		this.personWeight = scan.nextDouble();
//		return personWeight;
//	}
//
//	public String setPersonName() {
//		System.out.println("이름 입력:");
//		this.personName = scan.next();
//		return personName;
//	}
//
//	public int setPersonAge() {
//		System.out.println("나이 입력:");
//		this.personAge = scan.nextInt();
//		return personAge;
//	}
//
//	public String showPersonInfo() {
//		return "키 : " + personHeight + "\n" + "몸무게 : " + personWeight + "\n" + "이름 : " + personName + "\n" + "나이 : "
//				+ personAge + "\n";
//	}
//	
//}
//
//public class Person {
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		PersonInfo personInfo1 = new PersonInfo();
//		int personHeight = personInfo1.setPersonHeight();
//		double personWeight = personInfo1.setPersonWeight();
//		String personName = personInfo1.setPersonName();
//		int personAge = personInfo1.setPersonAge();
//		
//		System.out.println(personInfo1.showPersonInfo());
//	}
//
//}
