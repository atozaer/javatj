package kr.co.tj;

import java.util.ArrayList;

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

public class ArrayListTest03 {

	public static void main(String[] args) {
		ArrayList<Book> library = new ArrayList<Book>();
		Book book1 = new Book("태백산맥1", "조정래");
		Book book2 = new Book("태백산맥2", "조정래");
		Book book3 = new Book("태백산맥3", "조정래");
		Book book4 = new Book("태백산맥4", "조정래");
		Book book5 = new Book("태백산맥5", "조정래");
		
		//library.add(new Book("태백산맥1", "조정래"));
		library.add(book1);
		library.add(book2);
		library.add(book3);
		library.add(book4);
		library.add(book5);
		
		for(int i = 0; i<library.size();i++) {
			//library.get(i).showBookInfo();
			Book bookTest = library.get(i);
			bookTest.showBookInfo();
		}
		
	}

}
