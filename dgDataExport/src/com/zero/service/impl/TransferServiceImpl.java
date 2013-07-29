package com.zero.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zero.CommonAttributes;
import com.zero.DateUtil;
import com.zero.Template;
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
import com.zero.service.TemplateService;
import com.zero.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
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

	@Resource(name = "templateServiceImpl")
	private TemplateService templateService;

	protected final Logger log = Logger.getLogger(getClass());

	public void transferStPPTNR() {
		try{
			Template template =templateService.get(StPptnR.class.getName());
			Date stm =DateUtil.toDate(template.getStm(), CommonAttributes.DATE_PATTERNS[7]);
			boolean isCompleted = true;
			boolean flag = false;
			int first = 0;
			File file=null;
			String fileName = null;
			do {
				List<StPptnR> list =stPptnRService.findList(stm, first, 100);
				if(list.size()!=100){
					isCompleted=false;
				}
				first+=list.size();
				file = csvService.ListToCsv(list, flag);
				if(!flag){
					flag=true;
					if(list.size()>0){
						template.setStm(DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[7]));
						fileName = DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[8]);
					}
				}
			} while (isCompleted);
			if(file!=null){
				ftpService.sendTo("ST_PPTN_R_"+fileName+".csv",file);
				templateService.Update(template);
				file.delete();
			}
		}catch(Exception e ){
			log.error("出现异常：", e);
		}
	}

	public void transferStRiverR() {
		try{
			Template template =templateService.get(StRiverR.class.getName());
			Date stm =DateUtil.toDate(template.getStm(), CommonAttributes.DATE_PATTERNS[7]);
			boolean isCompleted = true;
			boolean flag = false;
			int first = 0;
			String fileName = null;
			File file=null;
			do {
				List<StRiverR> list =stRiverRService.findList(stm, first, 100);
				if(list.size()!=100){
					isCompleted=false;
				}
				first+=list.size();
				file = csvService.ListToCsv(list, flag);
				if(!flag){
					if(list.size()>0){
						template.setStm(DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[7]));
						fileName = DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[8]);
					}
					flag=true;
				}
			} while (isCompleted);
			if(file!=null){
				ftpService.sendTo("ST_RIVER_R_"+fileName+".csv",file);
				templateService.Update(template);
				file.delete();
			}
		}catch(Exception e ){
			log.error("出现异常：", e);
		}
	}

	public void transferStWasR() {
		try{
			Template template =templateService.get(StWasR.class.getName());
			Date stm =DateUtil.toDate(template.getStm(), CommonAttributes.DATE_PATTERNS[7]);
			boolean isCompleted = true;
			boolean flag = false;
			int first = 0;
			String fileName = null;
			File file=null;
			do {
				List<StWasR> list =stWasRService.findList(stm, first, 100);
				if(list.size()!=100){
					isCompleted=false;
				}
				first+=list.size();
				file = csvService.ListToCsv(list, flag);
				if(!flag){
					if(list.size()>0){
						template.setStm(DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[7]));
						fileName = DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[8]);
					}
					flag=true;
				}
			} while (isCompleted);
			if(file!=null){
				ftpService.sendTo("ST_WAS_R_"+fileName+".csv",file);
				templateService.Update(template);
				file.delete();
			}
		}catch(Exception e ){
			log.error("出现异常：", e);
		}
	}

	public void transferStRsvrR() {
		try{
			Template template =templateService.get(StRiverR.class.getName());
			Date stm =DateUtil.toDate(template.getStm(), CommonAttributes.DATE_PATTERNS[7]);
			boolean isCompleted = true;
			boolean flag = false;
			int first = 0;
			File file=null;
			String fileName = null;
			do {
				List<StRsvrR> list =stRsvrRService.findList(stm, first, 100);
				if(list.size()!=100){
					isCompleted=false;
				}
				first+=list.size();
				file = csvService.ListToCsv(list, flag);
				if(!flag){
					if(list.size()>0){
						template.setStm(DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[7]));
						fileName = DateUtil.getDateStr(list.get(0).getId().getTm(),CommonAttributes.DATE_PATTERNS[8]);
					}
					flag=true;
				}
			} while (isCompleted);
			if(file!=null){
				ftpService.sendTo("ST_RSVR_R_"+fileName+".csv",file);
				templateService.Update(template);
				file.delete();
			}
		}catch(Exception e ){
			log.error("出现异常：", e);
		}
	}

}
