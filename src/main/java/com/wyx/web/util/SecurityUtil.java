package com.wyx.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密的处理方法
 * 
 * @author Administrator
 * 
 */
public class SecurityUtil {

	public static String SHA1(String inStr) {
		MessageDigest md = null;
		String outStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1"); // 选择SHA-1，也可以选择MD5
			byte[] digest = md.digest(inStr.getBytes()); // 返回的是byet[]，要转化为String存储比较方便
			outStr = byte2Hex(digest);
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		return outStr;
	}


	/**
	 * 将字节数组转化为16进制字符串
	 * @param srcBytes
	 * @return
	 */
	private static String byte2Hex(byte[] srcBytes) {
		StringBuilder hexRetSB = new StringBuilder();
		for (byte b : srcBytes) {
			String hexString = Integer.toHexString(0x00ff & b);
			hexRetSB.append(hexString.length() == 1 ? 0 : "").append(hexString);
		}
		return hexRetSB.toString();
	}
}
