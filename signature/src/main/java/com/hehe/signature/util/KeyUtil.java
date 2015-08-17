package com.hehe.signature.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.hehe.signature.algorithm.Base64;

public class KeyUtil {
/*
	*//**
	 * 读取原始秘钥
	 * @param privateKey
	 * @return
	 *//*
	public static PrivateKey getPrivateKeyByASN1(String privateKey)   {
		byte[] keybyte = Base64.decode(privateKey);
		KeyFactory kf;
		try {
			RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(keybyte));  
			RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());  
			kf = KeyFactory.getInstance("RSA");
			return kf.generatePrivate(rsaPrivKeySpec);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	*/	
	
	/**
	 * 
	 * 读取私钥
	 */
	public static PrivateKey getPrivateKey(KeyFactoryAlgorithms keyFactoryAlgorithms,String privateKey) {
		byte[] keybyte = Base64.decode(privateKey);
		KeyFactory kf;
		try {
			kf = KeyFactory.getInstance(keyFactoryAlgorithms.value);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keybyte);
			return kf.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
	
	enum KeyFactoryAlgorithms{
		DiffieHellman("DiffieHellman"),DSA("DSA"),RSA("RSA"),EC("EC");
        private String value;
        private KeyFactoryAlgorithms(String value) {
            this.value = value;
        }
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}

	}
	
    /** 
     * 读取公钥 
     */  
	public static PublicKey getPublicKey(KeyFactoryAlgorithms keyFactoryAlgorithms,String publicKey) {  
		try {
			byte[] keybyte = Base64.decode(publicKey);
			KeyFactory kf = KeyFactory.getInstance(keyFactoryAlgorithms.value);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keybyte);
			return kf.generatePublic(keySpec);
		} catch (Exception e) {
			throw new RuntimeException("RSA获取公钥失败，公钥信息" + publicKey);
		}
    } 
}
