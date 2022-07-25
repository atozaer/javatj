// ——————————————— 배열 문제
// 배열 활용
// main 메소드가 포함되어 있는 ArrayQuest01 클래스를 생성.(* 원하는 클래스명이 있으면 별도 생성후 사용)
// 크기가 5인 int 타입의 number1 변수명의 배열을 만들어 3의 배수를 넣으시오.
// 얕은 복사 : copyNumber1의 변수를 생성하여 얕은 복사를 한다.
// number1, copyNumber1 내 결과값 확인
// copyNumber1 배열중 2번 배열방의 값을 7로 수정
// number1, copyNumber1 내 결과값 확인
// 크기가 26개인 char배열 alpha를 만들어 a~z까지의 값을 넣고 출력하세요
// 크기가 26인 copyAlpha를 만들어 alpha의 값을 복사해 넣고 출력하세요
// 깊은 복사 활용 : 깊은 복사 지원 함수 외 반복문을 활용해 깊은 복사
// copyAlpha를 이용하여 알파벳을 대문자로 출력하세요
// alpha 를 다시 한번 출력
// 문제 중점! 얕은 복사와 깊은 복사의 차이점을 알아본다.
/* 결과 :
3 6 9 12 15 
---------------------------
3 6 9 12 15 
---------------------------
3 6 7 12 15 
---------------------------
3 6 7 12 15 
---------------------------
a b c d e f g h i j k l m n o p q r s t u v w x y z 
---------------------------
a b c d e f g h i j k l m n o p q r s t u v w x y z 
---------------------------
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
---------------------------
a b c d e f g h i j k l m n o p q r s t u v w x y z 
*/

package kr.co.tj;

public class ArrayQuest01 {

	public static void main(String[] args) {
		int[] number1 = new int[5];
		
		for(int i = 0; i<=number1.length; i*=3) {
			
			if(i%3==0) {
				number1[i]=i;	
			}
			
		}
		System.out.println(number1[0]);
		System.out.println(number1[1]);
		System.out.println(number1[2]);
		System.out.println(number1[3]);
		System.out.println(number1[4]);
		
	}

}
