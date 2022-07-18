package kr.co.tj;

class DeskLamp{
	private boolean isOn;
	
	public DeskLamp() {
		
	}
	public void turnOn() {//램프를 켠다.
		isOn = true;
	}
	public void turnOff() {//램프를 끈다.
		isOn = false;
	}
	public String print() {
		String result = null;
		if(isOn == true) {
			result = "켜짐";
		}else {
			result = "꺼짐";
		}
		return "현재상태는 : "+result;
	}
}

public class DeskLampTest {

	public static void main(String[] args) {
		DeskLamp myLamp = new DeskLamp();
		myLamp.turnOn();
		String result = myLamp.print();
		System.out.println(result);
		myLamp.turnOff();
		result = myLamp.print();
		System.out.println(result);
		
	}

}
