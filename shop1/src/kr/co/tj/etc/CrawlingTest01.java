package kr.co.tj.etc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// modified by 서영준

class Shoes{
	private String shoesName;
	private int shoesPrice;
	
	public String getShoesName() {
		return shoesName;
	}
	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}
	public int getShoesPrice() {
		return shoesPrice;
	}
	public void setShoesPrice(int shoesPrice) {
		this.shoesPrice = shoesPrice;
	}
	
}

public class CrawlingTest01 {
	public static void main(String[] args) {
		// 크롤링할 주소지정
		String url = "https://www.shoemarker.co.kr/ASP/Product/New.asp";
		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
		String shoesName;
		int shoesPrice;
		String[] shoesPriceSplit;
		int a = 0;
		
		try {
			// 크롤링할 페이지의 테이터를 Document에 저장
			Document doc = Jsoup.connect(url).get();
			
			// 복사체(itr)을 활용하여 전체 데이터를 복사받기
			Iterator<Element> itr = doc.getElementsByClass("ns-type-bl-r").iterator();
			Iterator<Element> itr2 = doc.getElementsByClass("ns-type-bl-eb18x").iterator();
			
			while(itr2.hasNext()) {
				Shoes shoes = new Shoes();
				shoesName = itr.next().children().html();
				shoes.setShoesName(shoesName);
				shoesPriceSplit = itr2.next().html().split(" ");
				shoesPrice = Integer.parseInt(shoesPriceSplit[0].replace(",", ""));
				shoes.setShoesPrice(shoesPrice);
				shoesList.add(shoes);
			}
			
			for(Shoes data : shoesList) { //for문을 통한 전체출력
			    System.out.println(data.getShoesName() + " : " + data.getShoesPrice());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
