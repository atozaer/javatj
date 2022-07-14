package kr.co.tj2;

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Member() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
}

public class MemberTest {

	public static void main(String[] args) {
		Member member1 = new Member();
		member1.setName("이순신");
		member1.setAge(50);
		System.out.println(member1);
		System.out.println("나이:"+member1.getAge());
		System.out.println("이름:"+member1.getName());
	}

}
