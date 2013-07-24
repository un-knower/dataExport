package com.zero.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zero.service.CsvService;
import com.zero.service.FtpService;
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
	@Autowired
	@Qualifier("ftpServiceImpl")
	private FtpService ftpService;

	public void transferStPPTNR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		List list = oracleDataService.getStPPTNRList(c.getTime(), 1, 100);
		File file = csvService.ListToCsv(list, false);
		ftpService.sentTo(file);
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
