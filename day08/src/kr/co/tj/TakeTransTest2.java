package kr.co.tj;

class Student{
	String studentName;
	int grade;
	int money;
	
	public Student() {}
	public Student(String studentName, int money) {
		super();
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeTaxi(Taxi taxi) {
		taxi.take(10000);
		this.money-=10000;
	}
	@Override
	public String toString() {
		return studentName+"님의 남은 돈은 "+money+"원입니다.";
	}
}
class Taxi{
	public String TaxiName;
	public int money;

	public Taxi() {}
	public Taxi(String taxiName) {
		super();
		TaxiName = taxiName;
	}
	public void take(int money) {
		this.money+=10000;
	}
	@Override
	public String toString() {
		return TaxiName+"수입은"+money+"원입니다.";
	}
	
}
	
public class TakeTransTest2 {

	public static void main(String[] args) {
		Student studentW = new Student("Edward", 20000);
		Taxi wellTaxi = new Taxi("잘 간다 운수택시");
		
		studentW.takeTaxi(wellTaxi);
		
		System.out.println(studentW);
		System.out.println(wellTaxi);
		
	}

}
