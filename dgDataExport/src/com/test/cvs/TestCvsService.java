package com.test.cvs;

import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zero.service.OracleDataService;

public class TestCvsService {
	public static ApplicationContext cxt;

	@Test
	public void test() {
		// CsvService csvService = (CsvService) cxt.getBean("csvServiceImpl");
		// ArrayList<StPPTNR> data = new ArrayList<StPPTNR>();
		// data.add(new StPPTNR("1233", new Date(), 23.35));
		// csvService.ListToCsv(data);
		OracleDataService oracleDataService = (OracleDataService) cxt
				.getBean("OracleDataService");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		List list = oracleDataService.getStPPTNRList(c.getTime(), 1, 100);
		System.out.println(list.size());
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
