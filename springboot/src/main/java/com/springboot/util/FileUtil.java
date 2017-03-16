package com.springboot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @ClassName: FileUtil
 * @Description: 文件操作工具类
 * @author chenjl
 * @date 2017-3-16 下午11:36:26
 * 
 */
public class FileUtil {

	/**
	 * 加载属性文件*.properties
	 * 
	 * @param fileName
	 *            不是属性全路径名称，而是相对于类路径的名称
	 */
	public static Properties loadProps(String fileName) {
		Properties props = null;
		InputStream is = null;

		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);// 获取类路径下的fileName文件，并且转化为输入流
			if (is != null) {
				props = new Properties();
				props.load(is); // 加载属性文件
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return props;
	}

}