package kr.co.tj3;

class Book {
	private String title;
	private String author;

	public Book() {
		this("no", "no");
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public void showBookInfo() {
		System.out.println("책제목:"+title+" 저자:"+author);
	}

}

public class BookArrayTest {

	public static void main(String[] args) {
		Book[] library = new Book[5];//객체아님 공간만 만들어짐
		
		library[0] = new Book("태백산맥1", "조정래");
		library[1] = new Book("태백산맥2", "조정래");
		library[2] = new Book("태백산맥3", "조정래");
		library[3] = new Book("태백산맥4", "조정래");
		library[4] = new Book("태백산맥5", "조정래");
		
		for (int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
			library[i].showBookInfo();
		}
	}

}
