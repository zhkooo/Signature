package com.hehe.signature.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtil {

	public static String digest(HmacAlgorithms algorithm,String key, String str) {
		if (str == null) {
			return null;
		}
		 try {
			 SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm.value);
			 Mac mac = Mac.getInstance(algorithm.value);
			 mac.init(secretKey);
			 char[] hexB = Hex.encodeHex(mac.doFinal(str.getBytes("UTF-8")));
			 return new String(hexB);
		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	enum HmacAlgorithms{
		HmacMD5("HmacMD5"),HmacSHA1("HmacSHA1"),HmacSHA224("HmacSHA224"),HmacSHA256("HmacSHA256"),HmacSHA384("HmacSHA384"),HmacSHA512("HmacSHA512");
        private String value;
        private HmacAlgorithms(String value) {
            this.value = value;
        }
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}

	}

	public static void main(String[] args) {
		System.out.println(digest(HmacAlgorithms.HmacSHA256,"123456", "chenhaohao"));
	}
}
