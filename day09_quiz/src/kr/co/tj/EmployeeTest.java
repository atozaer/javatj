package kr.co.tj;

class Employee {
	private String name; // 사원이름
	private double salary; // 급여
	private static int count = 0;// 정적변수

	public Employee() {

	}

	public Employee(String n, double s) {
		name = n;
		salary = s;
		count++;
	}
	//객체가소멸될때 호출한다.
	protected void finalize() {
		count--;
	}
	public static int getCount() {
		return count;
	}
	
	
}

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e1 = new Employee("김승석", 35000.0);
		Employee e2 = new Employee("박천수", 50000.0);
		Employee e3 = new Employee("정명호", 20000.0);
		
		
		
		int n = Employee.getCount();
		System.out.println("현재의 직원수 = "+ n);
	}

}
