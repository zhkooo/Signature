package com.hehe.signature.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestUtil {

	public static String digest(MessageDigestAlgorithms algorithm, String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest m = MessageDigest.getInstance(algorithm.value);
			m.update(str.getBytes(), 0, str.length());
			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	enum MessageDigestAlgorithms{
		MD2("MD2"),MD5("MD5"),SHA1("SHA1"),SHA224("SHA-224"),SHA256("SHA-256"),SHA384("SHA-384"),SHA512("SHA-512");
        private String value;
        private MessageDigestAlgorithms( String value) {
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
		System.out.println(digest(MessageDigestAlgorithms.SHA512, "chenhaohao"));
	}
}
