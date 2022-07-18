package kr.co.tj;

class Date{
	private int year;
	private String month;
	private int day;
	
	public Date(int y, String m, int d) {
		year = y;
		month = m;
		day = d;
	}
	public void setDate(int y, String m, int d) {
		year = y;
		month = m;
		day = d;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void printDate() {
		System.out.println(year+"년"+month+"월"+day+"일");
	}
	
	
}

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(0, null, 0);
		date.setDate(2022, "7", 17);
		date.printDate();
		
		
	}

}
