package kr.co.tj;

import java.util.ArrayList;



public class ArrayListQuest02 {

	public static void main(String[] args) {
		int sum = 0;
		
		ArrayList<User> users = new ArrayList<>();
		User user1 = new User("일일일",111);
		User user2 = new User("이이이",222);
		User user3 = new User("삼삼삼",333);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i));
		}
		
		for(int i = 0; i<users.size(); i++) {
			sum+=users.get(i).age;
		}
		System.out.println(sum);
		
	}

}
