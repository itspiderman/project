package com.smeshop.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class CheckUtil {
	public static final String tooken = "smeshop123"; // Token, define by developer

	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		// 1.define array for tooken,timestamp,nonce
		String[] arr = { tooken, timestamp, nonce };
		// 2.Sort array
		Arrays.sort(arr);
		// 3.generate buffer string
		StringBuffer sb = new StringBuffer();
		for (String s : arr) {
			sb.append(s);
		}

		// 4.sha1 encrypt
		String temp = getSha1(sb.toString());
		// 5. compare encrypted string with the encrypted signature sent by wx, and return. 
		return temp.equals(signature);
	}

	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
