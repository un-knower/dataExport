package com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zero.service.TransferService;

@Controller
public class TransferController {
	@Autowired
	@Qualifier("transferServiceImpl")
	private TransferService transferService;

	@RequestMapping("test")
	public String Transfer() {
		transferService.transferStPPTNR();
		return "/list";
	}
}
