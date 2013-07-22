package com.zero.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zero.service.CsvService;
import com.zero.service.OracleDataService;
import com.zero.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	@Autowired
	@Qualifier("oracleDataServiceImpl")
	private OracleDataService oracleDataService;
	@Autowired
	@Qualifier("csvServiceImpl")
	private CsvService csvService;

	public void transferStPPTNR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		System.out.println(c.getTime());
		List list = oracleDataService.getStPPTNRList(c.getTime(), 1, 100);
		csvService.ListToCsv(list);
	}

	public void transferStRiverR() {
		// TODO Auto-generated method stub

	}

	public void transferStWasR() {
		// TODO Auto-generated method stub

	}

	public void transferStRsvrR() {
		// TODO Auto-generated method stub

	}

}
