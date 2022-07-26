// ——————————————— 반복문, 조건문 문제
// main 메소드가 포함되어 있는 RoopQuest03 클래스를 생성.(* 원하는 클래스명이 있으면 별도 생성후 사용)
// 86, 50두 수의 최대 공약수(2개 숫자는 원하는데로)
//1) 공약수를 구하자 공약수 공식 (https://mathbang.net/202)
//2) 그 중 가장 큰수를 구하자
//출력 결과 확인 후 공약수 계산기 이용해서 결과 비교 : https://codepen.io/jjkeb/full/mReYoN

package kr.co.tj;

import java.util.Scanner;

public class RoopQuest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요 : ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		int min;
		int gdc = 0;
		if(a<=b) {
			min = a;
		}else {
			min = b;
		}
		
		for(int i = 1; i<=min; i++) {
			if(a%i==0 && b%i==0) {
				gdc = i;
			}
		}
		
		System.out.println(a+","+b+"의 최대공약수는 "+gdc);
		
		
	}

}
