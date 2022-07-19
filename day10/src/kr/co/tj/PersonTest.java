package kr.co.tj;

class Person {
	private String lastName;
	private String firstName;

	public Person() {
	}

	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String buildName() {
		return String.format("성 = %s \n이름 = %s\n", this.getLastName(), this.getFirstName());
	}

}

public class PersonTest {

	public static void main(String[] args) {
		Person person = new Person("더", "조은");
		System.out.printf(person.buildName());

	}

}
