// —————————————————— List 문제 
// ArrayList numbers를 만들고
// 2~10까지의 숫자를 추가후 출력
// index 3의 숫자를 제거후 출력
// index 7에 100을 추가 후 출력
// 2의 배수를 보두 제거한 후 출력
// 3명 user 객체를 생성하여 arraylist에 담고 
// arraylist에 담긴 내용을 활용하여
//모든 사람의 정보를 출력
//모든 사람의 나이 총합을 구하여라

package kr.co.tj;

import java.util.ArrayList;

public class ArrayListQuest01 {

	public static void main(String[] args) {
		// 2~10까지의 숫자를 추가후 출력
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 2; i <= 10; i++) {
			numbers.add(i);
		}

		// index 3의 숫자를 제거후 출력
		numbers.remove(3);

		// index 7에 100을 추가 후 출력
		numbers.add(7, 100);

		// 2의 배수를 모두 제거한 후 출력

		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 != 0) {
				System.out.print(numbers.get(i) + " ");
			}
		}

		// 3명 user 객체를 생성하여 arraylist에 담고
		// arraylist에 담긴 내용을 활용하여
		// 모든 사람의 정보를 출력
		// 모든 사람의 나이 총합을 구하여라
		
		ArrayList user1 = new ArrayList();
		ArrayList user2 = new ArrayList();
		ArrayList user3 = new ArrayList();
		
		
		
		
		
	}

}
