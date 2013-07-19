/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.zero.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.zero.Template;
import com.zero.Template.Type;
import com.zero.service.TemplateService;

/**
 * Service - 模板
 * 
 * @author jianghao
 * @version 3.0
 */
@Service("templateServiceImpl")
public class TemplateServiceImpl implements TemplateService,
		ServletContextAware {

	/** servletContext */
	private ServletContext servletContext;

	@Value("${transferFile}")
	private String[] templateLoaderPaths;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@SuppressWarnings("unchecked")
	public List<Template> getAll() {
		try {
			File configXmlFile = new ClassPathResource(
					com.zero.CommonAttributes.CONFIG_XML_PATH).getFile();
			Document document = new SAXReader().read(configXmlFile);
			List<Template> templates = new ArrayList<Template>();
			List<Element> elements = document.selectNodes("/config/transfer");
			for (Element element : elements) {
				Template template = getTemplate(element);
				templates.add(template);
			}
			return templates;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Template> getList(Type type) {
		if (type != null) {
			try {
				File configXmlFile = new ClassPathResource(
						com.zero.CommonAttributes.CONFIG_XML_PATH).getFile();
				Document document = new SAXReader().read(configXmlFile);
				List<Template> templates = new ArrayList<Template>();
				List<Element> elements = document
						.selectNodes("/config/transfer[@type='" + type + "']");
				for (Element element : elements) {
					Template template = getTemplate(element);
					templates.add(template);
				}
				return templates;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return getAll();
		}
	}

	public Template get(String id) {
		try {
			File configXmlFile = new ClassPathResource(
					com.zero.CommonAttributes.CONFIG_XML_PATH).getFile();
			Document document = new SAXReader().read(configXmlFile);
			Element element = (Element) document
					.selectSingleNode("/config/transfer[@id='" + id + "']");
			if (element == null) {
				return null;
			}
			Template template = getTemplate(element);
			return template;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String read(String id) {
		Template template = get(id);
		return read(template);
	}

	public String read(Template template) {
		String templatePath = servletContext.getRealPath(templateLoaderPaths[0]
				+ template.getFilePath());
		File templateFile = new File(templatePath);
		String templateContent = null;
		try {
			templateContent = FileUtils.readFileToString(templateFile, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return templateContent;
	}

	public void write(String id, String content, Boolean append) {
		Template template = get(id);
		write(template, content, append);
	}

	public void write(Template template, String content, Boolean append) {
		String templatePath = servletContext.getRealPath(templateLoaderPaths[0]
				+ template.getFilePath());
		File templateFile = new File(templatePath);
		try {
			FileUtils.writeStringToFile(templateFile, content, "UTF-8", append);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(Template template, Collection<?> collection,
			Boolean append) {
		String templatePath = servletContext.getRealPath(templateLoaderPaths[0]
				+ template.getFilePath());
		File templateFile = new File(templatePath);
		try {
			FileUtils.writeLines(templateFile, "UTF-8", collection, "\r\n",
					true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取模板
	 * 
	 * @param element
	 *            元素
	 */
	private Template getTemplate(Element element) {
		String id = element.attributeValue("id");
		String type = element.attributeValue("type");
		String name = element.attributeValue("name");
		String entity = element.attributeValue("entity");
		String interval = element.attributeValue("interval");
		String filePath = element.attributeValue("filePath");

		Template template = new Template();
		template.setId(id);
		template.setType(Type.valueOf(type));
		template.setName(name);
		template.setEntity(entity);
		template.setInterval(interval);
		template.setFilePath(filePath);
		return template;
	}

}