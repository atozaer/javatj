package kr.co.tj;

class Time {
	private int hour;
	private int minute;
	private int second;

	public Time() {
		this(0, 0, 0);
	}

	public Time(int h, int m, int s) {
		hour = h;
		minute = m;
		second = s;
	}

	public String getTime() {
		return hour + ":" + minute + ":" + second;
	}

}

class AlarmClock {
	private Time currentTime;
	private Time alarmTime;

	public AlarmClock() {

	}

	public AlarmClock(Time a, Time c) {
		alarmTime = a;
		currentTime = c;
	}

	public void printAlarmClock() {

	}

	public void printAlarm() {
		System.out.println("알람시간 : " + alarmTime.getTime());
		System.out.println("현재시간 : " + currentTime.getTime());
	}

}

public class AlarmClockTest {

	public static void main(String[] args) {
		Time alarm = new Time(6, 0, 0);
		Time current = new Time(10, 21, 56);
		AlarmClock c = new AlarmClock(alarm, current);
		c.printAlarm();
	}

}
