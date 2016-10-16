package com.webcrawler.utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcrawler.constants.ApplicationConstants;

public class CrawlerUtils {

	
	
	public static Map<String ,List<String>> processMap= new LinkedHashMap<String ,List<String>> ();
	public static void processUrl(String url) throws IOException{
		
		
		Document doc = Jsoup.connect(url).get();
		//get all href links and image links
		getAllLinks(doc,url);
	}

	private static void getAllLinks(Document doc , String parentUrl) throws IOException {
			
		List<String> domainLinksList = new LinkedList<String>();
		if(!processMap.containsKey(parentUrl)){
			domainLinksList = new LinkedList<String>();
		}else{
			domainLinksList = processMap.get(parentUrl);
		}
			
		//get all href links 
		Elements links = doc.select("a[href]");
		
		for(Element link: links){
			if(link.attr("href").startsWith(ApplicationConstants.DOMAIN)){
				domainLinksList.add(link.attr("href"));
				processMap.put(parentUrl, domainLinksList);
				processUrl(link.attr("href"));
			}
		}
		//get all  image links
		links = doc.select("img");
		for(Element link: links){
			if(link.attr("src").startsWith(ApplicationConstants.DOMAIN)){
				domainLinksList.add(link.attr("src"));
				processMap.put(parentUrl, domainLinksList);
			}
		}

	}

}
