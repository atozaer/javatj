package kr.co.tj;

interface Calc{
	double PI = 3.14;
	int ERROR = -99999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
}

abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}

	@Override
	public int substract(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}
	
	
}

class CompleteCalc extends Calculator{

	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1*num2;
	}

	@Override
	public int divide(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num2==0) {
			return ERROR;
		}else {
			return num1/num2;
		}
	}
	
	public void showInfo() {
		System.out.println("모두 구현하였습니다.");
	}
	
}


public class CalculatorTest {

	public static void main(String[] args) {
		Calc calc = (Calc)new CompleteCalc();
		int num1 = 10;
		int num2 = 0;
		
		System.out.println(num1+"+"+num2+"="+calc.add(num1, num2));
		System.out.println(num1+"-"+num2+"="+calc.substract(num1, num2));
		System.out.println(num1+"*"+num2+"="+calc.times(num1, num2));
		System.out.println(num1+"/"+num2+"="+calc.divide(num1, num2));
		
		CompleteCalc cc = (CompleteCalc)calc;
		cc.showInfo();
	}

}
