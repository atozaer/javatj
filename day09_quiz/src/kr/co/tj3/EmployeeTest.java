package kr.co.tj3;

class Employee{
	private static int serialNum = 1000;
	
	private int employeeId;
	private String employeeName;
	private String department;
	

	public Employee() {
		serialNum++;
		employeeId = serialNum;
	}
	
	public static int getSerialNum() {
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		int i = 0;
		//employeeName = "Lee";//error 오류 발생
		Employee.serialNum = serialNum;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	
}

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employeeLee = new Employee();
		employeeLee.setEmployeeName("이순신");
		Employee employeeKim = new Employee();
		employeeKim.setEmployeeName("김유신");
		System.out.println(employeeLee.getEmployeeName()+":"+employeeLee.getEmployeeId());
		System.out.println(employeeKim.getEmployeeName()+":"+employeeKim.getEmployeeId());
		System.out.println(Employee.getSerialNum());
		Employee.setSerialNum(1003);
		System.out.println(Employee.getSerialNum());
	}

}
