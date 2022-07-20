package kr.co.tj3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {
	private String titleContent;
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<HashMap<String, String>> boardList = new ArrayList<HashMap<String,String>>();
	private int indexI;
	private String title;
	private String content;
	private String author;
	private String nal;
	private String readCount;
	
	public Register() {
		
	}
	public void registerTitleContnet() {
		System.out.println("제목|내용 입력하세요:");
		titleContent = Register.scan.next();
	}
	public void registerTitleContentProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}
	public void registerAuthor() {
		System.out.println("작성자입력:");
		author = Register.scan.next();
	}
	public void registerNal() {
		System.out.println("날짜입력:");
		nal = Register.scan.next();
	}
	public void registerReadCount() {
		System.out.println("조회수입력:");
		readCount = Register.scan.next();
	}
	public void registerProcess() {
		HashMap<String, String> boardHash = new HashMap<String, String>();
		boardHash.put("title", title);
		boardHash.put("content", content);
		boardHash.put("author", author);
		boardHash.put("nal", nal);
		boardHash.put("readCount", readCount);
		boardList.add(boardHash);
		System.out.println("게시글이 등록되었습니다.");
	}
}
