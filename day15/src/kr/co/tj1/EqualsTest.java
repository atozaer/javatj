package kr.co.tj1;

class Student implements Cloneable{
	private int studentId;
	private String studentName;
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(this.studentId == std.studentId) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
	
}

public class EqualsTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student Lee = new Student(100, "Lee");
		Student Lee2 = Lee;
		Student Park = new Student(100, "Park");
		
		System.out.println(Lee == Park);
		System.out.println(Lee.equals(Park));
		
		System.out.println(Lee.hashCode());
		System.out.println(Park.hashCode());
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode());
		
		System.out.println(System.identityHashCode(i1));
		System.out.println(System.identityHashCode(i2));
		
		Student Lee3 = (Student)Lee.clone();
		System.out.println(System.identityHashCode(Lee));
		System.out.println(System.identityHashCode(Lee3));
		
	}

}
