package com.gap.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

	public static String parseHtml(String url) {
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		Elements paragraphs = doc.select("p");
		for(Element p : paragraphs){
			sb.append(p.text().replaceAll("\\[.*?\\]", ""));
		}
		
		return sb.toString();
	}

	
}
