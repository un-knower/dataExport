package com.zero.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zero.Template;
import com.zero.service.CsvService;
import com.zero.service.TemplateService;

@Service("csvServiceImpl")
public class CsvServiceImpl implements CsvService {
	@Resource(name = "templateServiceImpl")
	private TemplateService templateService;
	protected final Logger log = Logger.getLogger(getClass());

	public File ListToCsv(List<?> list) {
		if (list.isEmpty()) {
			log.info("无数据");
			return null;
		} else {
			Object data = list.get(0);
			Template template = templateService.get(data.getClass().getName());
			templateService.write(template, list, true);
			log.info(template.getName() + "转换");
		}
		return null;
	}

	public File ListToCsv(List<?> list, String path) {
		return null;
	}

}
