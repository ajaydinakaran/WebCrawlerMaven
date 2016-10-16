package com.webcrawler.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webcrawler.constants.ApplicationConstants;
import com.webcrawler.utils.CrawlerUtils;

/*
 * This class contains all the rest api's mapping
 * */
@RestController
public class RestCrawlController {

	
	static Logger logger = Logger.getLogger(RestCrawlController.class.getName());
	
	
	@RequestMapping("/getLinks")
	public Map<String, List<String>> getLinks( HttpServletRequest req, HttpServletResponse resp) {

		logger.info("processing doc");
		try {
			CrawlerUtils.processUrl(ApplicationConstants.DOMAIN_HOME_PAGE_URL);
			logger.info("processed doc");
			resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			return CrawlerUtils.processMap;
		} catch (IOException e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			logger.severe("processing doc failed");
		}
		return null;
		

	
	}
}
