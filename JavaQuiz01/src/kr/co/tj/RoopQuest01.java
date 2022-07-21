// main 메소드가 포함되어 있는 RoopQuest01 클래스를 생성.(* 원하는 클래스명이 있으면 별도 생성후 사용)

// 1~100의 수중 3과 5의 배수는?

// 3의 배수와 5의 배수를 출력해라 - 기본 반복문 활용

// for문과 while문을 각각 사용하여 동일한 결과가 나오도록 해야함

// int[] 배열을 활용해 변환 // 전체를 담고 출력시 조건을 통한 출력 또는 담기 전 조건을 통한 배수값 등록 등 자율

// 결과 : 3 5 6 9 10 12 15 18 20 21 24 25 27 30 33 35 36 39 40 42 45 48 50 51 54 55 57 60 63 65 66 69 70 72 75 78 80 81 84 85 87 90 93 95 96 99 100

package kr.co.tj;

import java.util.ArrayList;

public class RoopQuest01 {

	public static void main(String[] args) {

//		for문 활용
		for(int i = 1; i<=100;i++) {
			if(i%3==0 || i%5==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();

//		while문 활용
		int j = 0;
		while(j<=100) {
			j++;
			if(j%3==0||j%5==0) {
				System.out.print(j+" ");
			}
		}
		System.out.println();
		
//		배열 활용
		int[] arr = new int[100];
		for(int a = 1; a<=arr.length; a++) {
			if(a%3==0||a%5==0) {
				System.out.print(a+" ");
			}
		}
		
		int[] arr2 = new int[100];
		
		
		
	}

}
