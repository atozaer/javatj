package kr.co.tj;

class Time {
	private int hour;
	private int minute;
	private int second;

	public Time(int h, int m, int s) {
		hour = h;
		minute = m;
		second = s;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour < 24) {
			this.hour = hour;
		} else {
			this.hour = 0;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute >= 0 && minute < 60) {
			this.minute = minute;
		} else {
			this.minute = 0;
		}

	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second >= 0 && second < 60) {
			this.second = second;
		} else {
			this.second = 0;
		}

	}

	public Time() {
		this(0, 0, 0);
	}

//	public void setTime(int h, int m, int s) {
//		if (h >= 0 && h < 24) {
//			hour = h;
//		} else {
//			hour = 0;
//		} // 시간검증
//		if (m >= 0 && m < 60) {
//			minute = m;
//		} else {
//			minute = 0;
//		} // 분검증
//		if (s >= 0 && s < 60) {
//			second = s;
//		} else {
//			second = 0;
//		} // 초검증
//	}

	public String printTime() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}

public class TimeTest {

	public static void main(String[] args) {
		Time time = new Time();
		System.out.print("기본생성자호출후 시간: ");
		System.out.println(time.printTime());
		
		Time time2 = new Time();
		time2.setHour(13);
		time2.setMinute(27);
		time2.setSecond(6);
		System.out.print("두번째생성자호출후 시간: ");
		System.out.println(time2.printTime());
		
		Time time3 = new Time();
		time3.setHour(99);
		time3.setMinute(66);
		time3.setSecond(77);
		System.out.println("올바르지않은 시간설정후 시간: ");
		System.out.println(time3.printTime());

	}

}
