package com.webcrawler.utils.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.webcrawler.config.AppConfig;
import com.webcrawler.utils.CrawlerUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class})
@WebAppConfiguration
public class CrawlerUtilTest {

	//to test null pointer
	@Test(expected=IllegalArgumentException.class)
	public void testProcessUrlWithNull() throws IOException {
		CrawlerUtils.processUrl(null);
		assertEquals(false, false);
		
	}
	
}
