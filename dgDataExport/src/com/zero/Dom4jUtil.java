package com.zero;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * <p>
 * Title:以DOM方式解析XML
 * </p>
 * .
 * 
 * @author zhoushengyu
 * @version 1.0
 */

public class Dom4jUtil {

	private static Log log = LogFactory.getLog(Dom4jUtil.class);

	/**
	 * 创建空的dom4j的document对象<Br>
	 * .
	 * 
	 * @return dom4j的document对象
	 */
	public static Document createDocument() {
		return DocumentHelper.createDocument();
	}

	/**
	 * 格式化xml字符串.
	 * 
	 * @param xml
	 * @return
	 * @author 姜浩
	 * @update 2011-8-30 下午01:06:36
	 */
	public static String formatXML(String xml) {

		StringWriter sw = new StringWriter();

		try {
			Document doc = getDocumentFromString(xml);

			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding(System.getProperty("file.encoding"));

			XMLWriter writer = new XMLWriter(sw, format);
			writer.write(doc);
		} catch (IOException ie) {
			log.error(ie);
		} catch (DocumentException de) {
			log.error(de);
		}
		return sw.toString();
	}

	/**
	 * 从将xml文件系列化为dom4j的document对象<Br>
	 * .
	 * 
	 * @param file
	 *            xml文件的File对象
	 * @return dom4j的document对象
	 */
	public static Document getDocumentFromFile(File file)
			throws MalformedURLException, DocumentException {

		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		return document;
	}

	/**
	 * 从将xml文件系列化为dom4j的document对象<Br>
	 * .
	 * 
	 * @param fileName
	 *            xml文件的realPath
	 * @return dom4j的document对象
	 */
	public static Document getDocumentFromFile(String fileName)
			throws MalformedURLException, DocumentException {

		return getDocumentFromFile(new File(fileName));

	}

	/**
	 * 从将xml数据流系列化为dom4j的document对象<Br>
	 * .
	 * 
	 * @param inputStream
	 *            xml数据流
	 * @return dom4j的document对象
	 */
	public static Document getDocumentFromInputStream(InputStream inputStream)
			throws DocumentException {

		SAXReader reader = new SAXReader();

		Document document = reader.read(inputStream);

		return document;

	}

	/**
	 * 从将xml文件系列化为dom4j的document对象<Br>
	 * .
	 * 
	 * @param fileName
	 *            xml文件的资源路径（相对于com包的路径）
	 * @return dom4j的document对象
	 */
	public static Document getDocumentFromResources(String fileName)
			throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(getResourceURL(fileName)
				.getFile()));
		return document;
	}

	/**
	 * 从将xml字符串系列化为dom4j的document对象<Br>
	 * .
	 * 
	 * @param dataXml
	 *            xml字符串
	 * @return dom4j的document对象
	 */
	public static Document getDocumentFromString(String dataXml)
			throws DocumentException {
		return DocumentHelper.parseText(dataXml);
	}

	/***************************************************************************
	 * 取得加载类的路径.
	 */
	private static URL getResourceURL(String resource) throws IOException {
		URL url = null;
		ClassLoader loader = Dom4jUtil.class.getClassLoader();
		if (loader != null) {
			url = loader.getResource(resource);
		}
		if (url == null) {
			url = ClassLoader.getSystemResource(resource);
		}
		if (url == null) {
			throw new IOException("Could not find resource " + resource);
		}
		return url;
	}

	/**
	 * 
	 * 插入node，解决dom4j没有insert的问题.
	 * 
	 * @param node
	 *            节点
	 * @param insertNode
	 * @param position
	 * @author 姜浩
	 * @update 2011-8-30 下午01:09:42
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertNode(Node node, Node insertNode, int position) {
		List nodeList = ((Element) node).elements();
		nodeList.add(position, insertNode);
	}

	/**
	 * 用xsl样式表转换dom4j的document对象<Br>
	 * .
	 * 
	 * @param document
	 *            被转换的dom4j的document对象
	 * @param stylesheetPath
	 *            样式表路径
	 * @return 转换后的字符串
	 */
	public static String styleDocumentFromFile(

	Document document,

	String stylesheetPath

	) throws Exception {

		String retStr = null;
		// load the transformer using JAXP

		TransformerFactory factory = TransformerFactory.newInstance();

		Transformer transformer = factory.newTransformer(

		new StreamSource(stylesheetPath)

		);

		// now lets style the given document

		DocumentSource source = new DocumentSource(document);

		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		transformer.transform(source, result);
		try {
			retStr = sw.getBuffer().toString();
		} catch (Exception ex) {
			throw ex;
		} finally {
			sw.close();
		}
		// return the transformed document

		// Document transformedDoc = result.getDocument();

		return retStr;
	}

	/**
	 * 用xsl样式表转换dom4j的document对象<Br>
	 * .
	 * 
	 * @param document
	 *            被转换的dom4j的document对象
	 * @param styleXsl
	 *            样式表内容字符串
	 * @return 转换后的字符串
	 */
	public static String styleDocumentFromString(

	Document document,

	String styleXsl

	) throws Exception {
		String retStr = null;
		// load the transformer using JAXP

		TransformerFactory factory = TransformerFactory.newInstance();

		Transformer transformer = factory.newTransformer(new StreamSource(
				new ByteArrayInputStream(styleXsl.getBytes("UTF8")))

		);

		// now lets style the given document

		DocumentSource source = new DocumentSource(document);

		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		transformer.transform(source, result);
		try {
			retStr = sw.getBuffer().toString();
		} catch (Exception ex) {
			throw ex;
		} finally {
			sw.close();
		}
		// return the transformed document

		// Document transformedDoc = result.getDocument();

		return retStr;
	}

	/**
	 * dom4j的document对象写入文件<Br>
	 * .
	 * 
	 * @param document
	 *            待写文件的dom4j的document对象
	 * @param path
	 *            存储的文件真是路径
	 */

	public static void write(Document document, String path) throws IOException {

		// 指定文件
		String encoding = System.getProperty("file.encoding");

		OutputFormat format = OutputFormat.createPrettyPrint();
		if (log.isDebugEnabled()) {
			log.debug(encoding);
		}
		File file = new File(path);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}
		format.setEncoding(encoding);
		XMLWriter writer = new XMLWriter(new FileWriter(new File(path)), format);
		writer.write(document);

		/*
		 * XMLWriter writer = new XMLWriter(new OutputStreamWriter(new
		 * FileOutputStream( path ),encoding)); writer.write(document);
		 */
		writer.close();
	}

	/**
	 * 字符串写入文件<Br>
	 * .
	 * 
	 * @param content
	 *            待写文件的字符串
	 * @param fileName
	 *            存储的文件真是路径
	 */
	public static void writeFile(String content, String fileName) {
		try {
			File tmpFile = new File(fileName);

			if (tmpFile.exists()) {
				tmpFile.delete();
			}

			FileWriter fw = new FileWriter(fileName, true);
			fw.write(content);
			fw.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Dom4jUtil() {

	}
}
