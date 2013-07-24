package com.zero.service;

import java.io.File;
import java.util.List;

public interface CsvService {

	/**
	 * 把一个list里的数据转成csv文件，并保存在指定目录
	 * 
	 * @param list
	 *            要转成csv格式的数据
	 * @param path
	 *            要保存的文件路径
	 * @return csv文件
	 */
	public File ListToCsv(List<?> list, Boolean append);
}
