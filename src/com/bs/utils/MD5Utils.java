package com.bs.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/
public class MD5Utils {
    /**
	 * 使用MD5算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有MD5这个算法");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	public static void main(String[] args) {
		System.out.println(md5("1212"));
	}
}
