package kr.co.tj;

abstract class Computer {
	protected boolean isOnOff;

	public abstract void display();

	public abstract void typing();

	public boolean turnOn() {
		return this.isOnOff = true;
	}

	public boolean turnOff() {
		return this.isOnOff = false;
	}

	public void showPowerInfo() {
		if (this.isOnOff == true) {
			System.out.println("전원이 켜져있습니다.");
		} else if (this.isOnOff == false) {
			System.out.println("전원이 꺼져있습니다.");
		}

	}

}

class Desktop extends Computer {

	@Override
	public void display() {
		System.out.println("데스크탑디스플레이");
	}

	@Override
	public void typing() {
		System.out.println("데스크탑타이핑");
	}

}

class Notebook extends Computer {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public void typing() {
		// TODO Auto-generated method stub

	}

}

public class ComputerTest {

	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		desktop.turnOn();
		desktop.showPowerInfo();
		desktop.turnOff();
		desktop.showPowerInfo();
	}

}
