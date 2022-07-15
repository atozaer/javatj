package kr.co.tj;

class BirthDay{
	private int day;
	private int month;
	private int year;
	private boolean isValid;
	
	public BirthDay(int day, int month, int year, boolean isValid) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.isValid = isValid;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
			
		if(month<1||month>12) {
			isValid = false;
		}else {
			this.month = month;
			isValid = true;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String str="";
		if(isValid) {
			str = year+"년"+month+"월"+day+"일 입니다.";	
		}else {
			str = "유효하지않은 날짜입니다.";
		}
		return str;
	}

	public BirthDay() {
		super();
	}
	
	
	
}

public class BirthDayTest {

	public static void main(String[] args) {
		BirthDay date = new BirthDay();
		
		date.setYear(2022);
		date.setMonth(7);
		date.setDay(15);
		System.out.println(date);
	}

}
