package com.zero.service.impl;

import java.io.File;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zero.Page;
import com.zero.Pageable;
import com.zero.entity.StPptnR;
import com.zero.entity.StRiverR;
import com.zero.entity.StRsvrR;
import com.zero.entity.StWasR;
import com.zero.service.CsvService;
import com.zero.service.FtpService;
import com.zero.service.StPptnRService;
import com.zero.service.StRiverRService;
import com.zero.service.StRsvrRService;
import com.zero.service.StWasRService;
import com.zero.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	// @Autowired
	// @Qualifier("oracleDataServiceImpl")
	// private OracleDataService oracleDataService;
	@Autowired
	@Qualifier("csvServiceImpl")
	private CsvService csvService;
	@Autowired
	@Qualifier("ftpServiceImpl")
	private FtpService ftpService;
	@Autowired
	@Qualifier("stPptnRServiceImpl")
	private StPptnRService stPptnRService;
	@Autowired
	@Qualifier("stRiverRServiceImpl")
	private StRiverRService stRiverRService;
	@Autowired
	@Qualifier("stRsvrRServiceImpl")
	private StRsvrRService stRsvrRService;
	@Autowired
	@Qualifier("stWasRServiceImpl")
	private StWasRService stWasRService;

	public void transferStPPTNR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		Pageable pageable = new Pageable(1, 20);
		Page<StPptnR> page = stPptnRService.findPage(pageable);
		File file = csvService.ListToCsv(page.getContent(), false);
		ftpService.sentTo(file);
	}

	public void transferStRiverR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		Pageable pageable = new Pageable(1, 20);
		Page<StRiverR> page = stRiverRService.findPage(pageable);
		File file = csvService.ListToCsv(page.getContent(), false);
		ftpService.sentTo(file);
	}

	public void transferStWasR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		Pageable pageable = new Pageable(1, 20);
		Page<StWasR> page = stWasRService.findPage(pageable);
		File file = csvService.ListToCsv(page.getContent(), false);
		ftpService.sentTo(file);

	}

	public void transferStRsvrR() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -5);
		Pageable pageable = new Pageable(1, 20);
		Page<StRsvrR> page = stRsvrRService.findPage(pageable);
		File file = csvService.ListToCsv(page.getContent(), false);
		ftpService.sentTo(file);

	}

}
