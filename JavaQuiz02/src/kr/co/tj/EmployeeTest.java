package kr.co.tj;

import java.util.HashMap;
import java.util.Set;

class Employee {
	String name;
	int empno;
	int salary;
	String addres;
	

	public Employee() {
	}

	public Employee(String name, int salary, String addres) {
		this.name = name;
		this.salary = salary;
		this.addres = addres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

}

public class EmployeeTest {

	public static void main(String[] args) {
		HashMap<Integer, Employee> employees = new HashMap<>();
		
		employees.put(1001, new Employee("일일일", 2000, "부산시"));
		employees.put(1002, new Employee("이이이", 3000, "서울시"));
		employees.put(1003, new Employee("삼삼삼", 4000, "인천시"));
		
		Set<Integer> keys = employees.keySet();
		
		for (Integer key: keys) {
			System.out.println(key+":"+employees.get(key).name+":"+employees.get(key).salary);
		}
		
//		Employee e1 = new Employee("일일일", 2000, "부산시");
//		Employee e2 = new Employee("이이이", 3000, "서울시");
//		Employee e3 = new Employee("삼삼삼", 4000, "인천시");

		//employees.put(, );
	}

}
