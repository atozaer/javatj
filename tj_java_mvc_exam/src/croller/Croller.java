package croller;



import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Croller {
	public static void main(String[] args) {
		// 크롤링 주소지정
		// 스타일난다 베스트 카테고리 상품 크롤링
		String url = "https://stylenanda.com/product/list.html?cate_no=3540";
		
		// 크롤링의 페이지의 데이터를 Document에 저장
		try {
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Iterator<Element> iter = doc.select("ul.column4 > li div.inner-box").iterator();
			while (iter.hasNext()) {
				String productName = iter.next().select("div.name > a").text().replace("상품명 : ", "").replaceAll("[ ]#.*", "");
				int price = Integer.parseInt(iter.next().select("div.table > div.price_wrap > span.price").text().replaceAll("[^0-9]","")); // 판매가
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
