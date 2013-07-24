package com.zero.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zero.service.FtpService;

@Service("ftpServiceImpl")
public class FtpServiceImpl implements FtpService {
	@Value("${ftp.user}")
	private String user;
	@Value("${ftp.password}")
	private String password;
	@Value("${ftp.path}")
	private String path;
	@Value("${ftp.url}")
	private String url;
	@Value("${ftp.port}")
	private Integer port;
	@Value("${ftp.fcharset}")
	private String fCharset;
	@Value("${ftp.tcharset}")
	private String tCharset;
	private FTPClient ftp;
	protected final Logger log = Logger.getLogger(getClass());

	public void sentTo(File file) {
		if (ftp == null) {
			ftp = new FTPClient();
		}
		try {
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			ftp.login(user, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("连接ftp失败失败" + reply);
			}
			log.info("连接ftp成功");
			Boolean flag = ftp.changeWorkingDirectory(new String(path
					.getBytes(fCharset), tCharset));
			if (!flag) {
				log.info("改变工作路径失败" + path);
			}
			FileInputStream input = new FileInputStream(file);
			ftp.storeFile(file.getName(), input);
			input.close();
			ftp.logout();
			log.info("上传文件成功" + file.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
	}

	public void sentTo(String path, File file) {

	}

}
