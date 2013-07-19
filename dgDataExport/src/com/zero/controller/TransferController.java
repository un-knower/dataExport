package com.zero.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.cvs.StPPTNR;
import com.zero.service.CsvService;

@Controller
public class TransferController {
	@Autowired
	@Qualifier("csvServiceImpl")
	private CsvService csvService;

	@RequestMapping("test")
	public String Transfer() {
		ArrayList<StPPTNR> data = new ArrayList<StPPTNR>();
		for (int i = 0; i < 20; i++) {
			data.add(new StPPTNR("1233", new Date(), 23.35));
		}
		csvService.ListToCsv(data);
		return "/list";
	}
}
