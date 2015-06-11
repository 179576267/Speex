package com.gauss.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.util.Log;

public class Tools {
	/**
	 * 存储
	 * @param data
	 * @param name
	 */
	public static String saveFileFromByte(byte[] data, String name) {
		
			
		File file = new File(name);

		// 创建输出流
		FileOutputStream outStream;
		try {
			outStream = new FileOutputStream(file);
			outStream.write(data); // 写入数据
			outStream.close(); // 关闭输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return file.getAbsolutePath();
	}
	
	
	
	/**
	 * 文件转化为字节数组
	 * 
	 * @param file
	 * @param type 1==图片  2==语音
	 * @return
	 */
	public static byte[] getBytesFromFile(String path) {

		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		
			byte[] ret = null;
			try {
				FileInputStream in = new FileInputStream(file);
				ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
				byte[] b = new byte[4096];
				int n;
				while ((n = in.read(b)) != -1) {
					out.write(b, 0, n);
				}
				in.close();
				out.close();
				ret = out.toByteArray();
			} catch (IOException e) {
				// log.error("helper:get bytes from file process error!");
				e.printStackTrace();
			}
			return ret;
		
	}

}
