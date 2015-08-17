package com.hehe.signature.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import com.hehe.signature.algorithm.Base64;
import com.hehe.signature.util.KeyUtil.KeyFactoryAlgorithms;

public class SignatureUtil {

	public static byte[] sign(SignatureAlgorithms algorithm,PrivateKey priKey, String str) {
		if (str == null) {
			return null;
		}
		 try {
		 	Signature signature = Signature.getInstance(algorithm.value);
			signature.initSign(priKey);
			signature.update(str.getBytes("UTF-8"));
			byte[] signed = signature.sign();
			return signed;
		} catch ( UnsupportedEncodingException | SignatureException | InvalidKeyException | NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	enum SignatureAlgorithms{
		NONEwithRSA("NONEwithRSA"),MD2withRSA("MD2withRSA"),MD5withRSA("MD5withRSA"),SHA1withRSA("SHA1withRSA"),
		SHA224withRSA("SHA224withRSA"),SHA256withRSA("SHA256withRSA"),SHA384withRSA("SHA384withRSA"),SHA512withRSA("SHA512withRSA"),
		NONEwithDSA("NONEwithDSA"),SHA1withDSA("SHA1withDSA"),SHA224withDSA("SHA224withDSA"),SHA256withDSA("SHA256withDSA"),
		NONEwithECDSA("NONEwithECDSA"),SHA1withECDSA("SHA1withECDSA"),SHA224withECDSA("SHA224withECDSA"),SHA256withECDSA("SHA256withECDSA"),
		SHA384withECDSA("SHA384withECDSA"),SHA512withECDSA("SHA512withECDSA"),;
        private String value;
        private SignatureAlgorithms(String value) {
            this.value = value;
        }
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}

	}

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PrivateKey privateKey = null;
		privateKey = KeyUtil.getPrivateKey(KeyFactoryAlgorithms.RSA, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMyhqDiCTFYAnMxmWc3vM+5UXY8y9ip4OHIEP5O7zpPQ+g2ZS5dvgxi2YUZhmD3wG1JBPUBFD1YN2g1fkpeissPo7AzckhVp+5CwT4PtVg1QaHzZWcKxa1mgJ8Y84hzETQFcOq/l3lJjFJkStrKqN/0lFfrxwItQOyWuDiUG7irxAgMBAAECgYBCgbfexdpxiTls5UcCu1+xchIGXJXNL82IoQDYzw1Q1XavvMborQF6oqvy5/1HBCadET8LCGb3nQDln85RIjvfAzv75KmGk6aULp+ERA1gkj+SzwtVd0YdOvRNgaaW+0dr4bXE8zp0hrHN+KxYZQfsfIi/3NsYOPGaBhJFehvawQJBAPbxIbdzSTAarQUh7iUjiNctMUyl9AX8O6dfs1ynJg3LptzZFkRdzzjbmViBH/f2UM0UwPb3kLQvaPnlRzW3/XUCQQDUIzdJyNk9hK7qctOcnxyWdaVGPx9z3UBI2zO8XXlbzoYvLA9/wqqrOm7lNWp9LYLyEhiYoNLBO+u5ovuSN5wNAkB8iv7DRBysazfJ9+PgzTwtsfhEPQqGnkED2Ctg1lhF6uk8RyyIzHs/pNmBHpad+5ei5w2vQQq1JZgfOLiiaiolAkAFuQ18yBZUOogdewuKZiB3TqUux/UpQwbA8Gjs4/iqKWAlVaL1Z2MDS4hCVraQufGWZjaTp4MIA33QfD0dLLLhAkEAzc1oPM5KQyQVRk2uGUAsblhhxGEDDNSLjFQsjDjsqpKt22Tlr6eBsI5QXVW3/3P3U4F2WiZZMcF4+mm6TNMKFg==");
//		byte[] keybyte = Base64.decode("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMyhqDiCTFYAnMxmWc3vM+5UXY8y9ip4OHIEP5O7zpPQ+g2ZS5dvgxi2YUZhmD3wG1JBPUBFD1YN2g1fkpeissPo7AzckhVp+5CwT4PtVg1QaHzZWcKxa1mgJ8Y84hzETQFcOq/l3lJjFJkStrKqN/0lFfrxwItQOyWuDiUG7irxAgMBAAECgYBCgbfexdpxiTls5UcCu1+xchIGXJXNL82IoQDYzw1Q1XavvMborQF6oqvy5/1HBCadET8LCGb3nQDln85RIjvfAzv75KmGk6aULp+ERA1gkj+SzwtVd0YdOvRNgaaW+0dr4bXE8zp0hrHN+KxYZQfsfIi/3NsYOPGaBhJFehvawQJBAPbxIbdzSTAarQUh7iUjiNctMUyl9AX8O6dfs1ynJg3LptzZFkRdzzjbmViBH/f2UM0UwPb3kLQvaPnlRzW3/XUCQQDUIzdJyNk9hK7qctOcnxyWdaVGPx9z3UBI2zO8XXlbzoYvLA9/wqqrOm7lNWp9LYLyEhiYoNLBO+u5ovuSN5wNAkB8iv7DRBysazfJ9+PgzTwtsfhEPQqGnkED2Ctg1lhF6uk8RyyIzHs/pNmBHpad+5ei5w2vQQq1JZgfOLiiaiolAkAFuQ18yBZUOogdewuKZiB3TqUux/UpQwbA8Gjs4/iqKWAlVaL1Z2MDS4hCVraQufGWZjaTp4MIA33QfD0dLLLhAkEAzc1oPM5KQyQVRk2uGUAsblhhxGEDDNSLjFQsjDjsqpKt22Tlr6eBsI5QXVW3/3P3U4F2WiZZMcF4+mm6TNMKFg==");
//		KeyFactory kf;
//		kf = KeyFactory.getInstance("RSA");
//		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keybyte);
//		privateKey = kf.generatePrivate(keySpec);
		System.out.println(new String(Base64.encode(sign(SignatureAlgorithms.SHA224withRSA,privateKey, "chenhaohao"))));
	}
}
