package com.test.cvs;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCvsService {
	public static ApplicationContext cxt;

	@Test
	public void test() {
		// CsvService csvService = (CsvService) cxt.getBean("csvServiceImpl");
		// ArrayList<StPPTNR> data = new ArrayList<StPPTNR>();
		// data.add(new StPPTNR("1233", new Date(), 23.35));
		// csvService.ListToCsv(data);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
