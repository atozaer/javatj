package kr.co.tj.client;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test01 {

	public static void main(String[] args) {
		// 크롤링할 주소 지정
		String url = "https://www.melon.com";

		try {
			// 크롤링할 페이지의 데이터를 Document에 저장
			Document doc = Jsoup.connect(url).get();

			// 복사체(iterater)를 활용하여 전체데이터를 복사 받음
			Iterator<Element> itr = doc.select("div > span > a").iterator();

			// 저장된 데이터 확인
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
