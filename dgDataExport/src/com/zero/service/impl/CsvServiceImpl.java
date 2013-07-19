package com.zero.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
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
			for (Object object : list) {
				try {
					File templateFile = new File(template.getFilePath());
					FileUtils.writeStringToFile(templateFile,
							object.toString(), "UTF-8");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.info(template.getName() + "转换");
		}
		return null;
	}

	public File ListToCsv(List<?> list, String path) {
		return null;
	}

}
