package com.test.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;

public class TestFtp {
	public static final String USAGE = "在在在";

	@Test
	public void test() {
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect("www.wujiaw.com", 12121);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login("de", "0PQH9w4P");// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.out.println("连接失败");
			}
			System.out.println("连接成功");
			System.out.println(FTP.DEFAULT_CONTROL_ENCODING);
			Boolean flag = ftp.changeWorkingDirectory(new String("/新建文件夹/"
					.getBytes(), FTP.DEFAULT_CONTROL_ENCODING));
			if (flag) {
				FileInputStream input = new FileInputStream(new File(
						"E:/stockpond.asp"));
				ftp.storeFile("ftp.txt", input);
				input.close();
			} else {
				System.out.println("error");
			}
			ftp.logout();
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

}
