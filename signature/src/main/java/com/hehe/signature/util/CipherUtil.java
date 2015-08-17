package com.hehe.signature.util;

import java.security.Key;

import javax.crypto.Cipher;

public class CipherUtil {

	/**
	 * 
	 * @param cipherAlgorithm
	 * 两种形式：
	 * 1."algorithm/mode/padding" 如DES/CBC/PKCS5Padding
	 * 2."algorithm" 如：RSA,AES,AESWrap,ARCFOUR,Blowfish,DES,DESede,DESedeWrap,ECIES
	 * RC2,RC4,RC5,RSA,PBEWith<digest>And<encryption> PBEWith<prf>And<encryption>
	 * 
	 * "mode":NONE,CBC,CCM,CFB, CFBx,CTR,CTS,ECB,GCM,OFB, OFBx,PCBC
	 * 
	 * "padding":PKCS1Padding,PKCS5Padding,SSL3Padding,ISO10126Padding,OAEPPadding, OAEPWith<digest>And<mgf>Padding
	 * @param key
	 * @param plainText 
	 * @param mode Cipher.ENCRYPT_MODE：加密 Cipher.DECRYPT_MODE 解密
	 * @return
	 */
	public static  byte[] encrypt(String cipherAlgorithm ,Key key, String plainText,int mode) {
		try {
			Cipher cipher = Cipher.getInstance(cipherAlgorithm);
			cipher.init(mode, key);
			byte[] enBytes = cipher.doFinal(plainText.getBytes("utf-8"));
			return enBytes;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
	
  
}
