package kr.co.tj.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.tj.model.BoardVO;
import kr.co.tj.model.ProductVO;


public class BoardView {
	Scanner sc  = new Scanner(System.in);
	
	public String protocol;
	public String titleContent;
	public int indexI=0;
	public SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public void clientView() {
		System.out.println("C:등록R:검색U:수정D:삭제L:전체출력");
		String protocol1=sc.next();
		protocol=protocol1.toUpperCase();
	}
	public void action1() {
		System.out.println("제목|내용 입력:");
		titleContent = sc.next();
	}
	public String action1_A() {
		int indexI = titleContent.indexOf("|");
		String title=titleContent.substring(0,indexI);
		return title;
	}
	public String action1_B() {
		String content=titleContent.substring(indexI+1);
		return content;
	}
	public String action2() {
		System.out.println("작성자입력:");
		String author = sc.next();
		return author;
	}
	public int action3() {
		System.out.println("조회수입력:");
		int readcount = sc.nextInt();
		return readcount;
	}
	public void action4() {
		System.out.println("게시글이등록되었습니다.");
	}
	public String action5() {
		System.out.println("검색할제목을 입력하세요:");
		String title = sc.next();
		return title;
	}
	public void action6(BoardVO vo) {
		System.out.print(vo.getNo()+"\t"+vo.getTitle()+"\t"+vo.getContent()+"\t\t"+vo.getAuthor()+"\t"+sdf1.format(vo.getNal())+"\t"+vo.getReadcount()+"\n");
	}
	public void action7() {
		System.out.println("수정할게시글제목입력:");
		String title=sc.next();
	}
	public void action8() {
		System.out.println("수정하기 전내용입니다.");			
		System.out.println("수정할게시글제목|내용입력:");
		String titleContent = sc.next();
	}
	public void action9() {
		System.out.println("정말로수정하시겠습니까y/n");
		String select=sc.next();
	}
	
	public void action10() {
		System.out.println("게시글이수정되었습니다.");
	}
	public void action11() {
		System.out.println("수정취소");
	}
	public String action12() {
		System.out.println("삭제할제목입력:");
		String title = sc.next();
		return title;
	}
	public void action13() {
		System.out.println("게시글이 삭제되었습니다.");
	}
	public void action14() {
		System.out.println("전체출력");
		System.out.print("no\t title\t cotnent\t author\t nal\t\t\t readcount\n");
	}
	public void action15(ArrayList<BoardVO> datas) {
		System.out.println("====상품목록 페이지=====");
		for(BoardVO vo:datas) {
			System.out.println(vo);
		}	
		//System.out.print(data.getNo()+"\t"+data.getTitle()+"\t"+data.getContent()+"\t\t"+data.getAuthor()+"\t"+sdf1.format(data.getNal())+"\t"+data.getReadcount()+"\n");
	}
}
