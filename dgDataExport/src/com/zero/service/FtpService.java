package com.zero.service;

import java.io.File;

/**
 * 处理ftp请求
 * 
 * @author 浩
 * 
 */
public interface FtpService {
	/**
	 * 把指定的文件上传到ftp服务器
	 * 
	 * @param file
	 *            要上传的文件
	 */
	public void sendTo(File file);

	/**
	 * 把指定的文件上传到ftp服务器的指定目录
	 * 
	 * @param path
	 * @param file
	 */
	public void sendTo(String filename, File file);
}
