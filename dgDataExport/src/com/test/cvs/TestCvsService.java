package com.test.cvs;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class TestCvsService {
	public static ApplicationContext cxt;

	@Test
	public void test() {
		// CsvService csvService = (CsvService) cxt.getBean("csvServiceImpl");
		// ArrayList<StPPTNR> data = new ArrayList<StPPTNR>();
		// data.add(new StPPTNR("1233", new Date(), 23.35));
		// csvService.ListToCsv(data);
		File file = new File("d://test/test.csv");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.getName());
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//		try {
		//			cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
	}
}
