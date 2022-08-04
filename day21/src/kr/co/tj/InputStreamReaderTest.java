package kr.co.tj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class User {
	private String id;
	private String passwd;
	private String dong;
	private int age;
	private String name;

	public User() {
		this(null, null, null, 0, null);
	}

	public User(String id, String passwd, String dong, int age, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.dong = dong;
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", passwd=" + passwd + ", dong=" + dong + ", age=" + age + ", name=" + name + "]";
	}
}

public class InputStreamReaderTest {
	InputStreamReader isr = null;
	BufferedReader bfr = null;

	public static void main(String[] args) {
		InputStreamReaderTest isrt = new InputStreamReaderTest();
		User user = isrt.getUserInfo();
		System.out.println("입력한사용자정보:");
		System.out.println(user);
	}

	private User getUserInfo() {
		User user = null;
		isr = new InputStreamReader(System.in);
		bfr = new BufferedReader(isr);
		try {
			System.out.println("사용자정보를입력하세요:");
			System.out.print("아이디:");
			String id = bfr.readLine();
			System.out.print("패스워드:");
			String passwd = bfr.readLine();
			System.out.print("동:");
			String dong = bfr.readLine();
			System.out.print("나이:");
			int age = Integer.parseInt(bfr.readLine());
			System.out.print("이름:");
			String name = bfr.readLine();

			user = new User(id, passwd, dong, age, name);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
