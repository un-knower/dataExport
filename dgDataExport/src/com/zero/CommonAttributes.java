package com.zero;

/**
 * 公共参数
 * 
 * @author jianghao
 * @version 3.0
 */
public final class CommonAttributes {

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy",
			"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd",
			"yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss",
			"yyyy/MM/dd HH:mm:ss" };

	/** config.xml文件路径 */
	public static final String CONFIG_XML_PATH = "/config.xml";

	/** config.properties文件路径 */
	public static final String CONFIG_PROPERTIES_PATH = "/config.properties";

	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}