package kr.co.tj;

class Employee{
	public String name;
	private int RRN;
	protected int salary;
	String address;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", RRN=" + RRN + ", salary=" + salary + ", address=" + address + "]";
	}
}
class Manager extends Employee{
	private int bonus;
	public void printSalary(){
		System.out.println(name+":"+address+":"+(salary+bonus));
	}
	public void printRRN() {
		//System.out.println(RRN);	슈퍼클래스의 변수가 private이므로 사용불가
	}
}

public class ManagerTest {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.printRRN();
	}

}
