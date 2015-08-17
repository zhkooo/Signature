package com.hehe.signature.algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 *Message Digest algorithm 5，信息摘要算法
 *
 */
public class MD5 {

	public final static String encode1(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String encode(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	/**
	 * 恒朋MD5加密
	 * @param s
	 * @param encode
	 * @return
	 */
	public final static String HPEncode(String s,String encode) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes(encode);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

	
	/**
	 * MD5标准计算摘要
	 * */
	public static String digest(String inbuf) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(inbuf.getBytes(), 0, inbuf.length());
			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String [] arr){
	   // String str="456014201103189145766020110318172833<body><issueNotify><issue gameName=\"ssl\" number=\"2011031815\" startTime=\"2011-03-18 16:58:00\" stopTime=\"2011-03-18 17:28:00\" status=\"3\" bonusCode=\"\" salesMoney=\"-1.0\" bonusMoney=\"-1.0\"/></issueNotify></body></message>";
//        System.out.println(MD5.HPEncode(str,"GBK"));
//        System.out.println(MD5.encode("wapclientadmin"));
        System.out.println(MD5.encode("MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAPTZQcJEaX3zQFIvyfGnqQqa+SSbAsLLwMVI9zaSHPCJZ1/jZFbHssGTtPq7WbG2Odq1rOF3NuLBMNHtLJs9LPotfYn9/3KfS1RhXBDmqecH4bt7WxMT0K8cXBOHxgmlmAHv1zTp8sc0yJaqnMS8uiqESwscBSa7dYRhby3sz3JDAgMBAAECgYEAgGKa9H5iwkQWagHc5fV/0avJD8SoAfRMtCW6WsbqncWuirz1E/vKY25L61zpfyGJ3IB+kgqsoOGj869lQFEnj1BN7FlpO3X27OTVtSGW4zLrP3N89N9hMftguNZ+VogT6DzRz98aGBaKEZhGhk0BdqzLxF/sg2i5A26nsIZVMSECQQD969bkij7OFQjhlJ6vHeZWvcMjyWlAac8huOXCYcnrfYI6kbyuLIFHf/au9asnHQFlPv465juPrt2Km5u3M9gVAkEA9tpnRFOGAgEkhjnbtZhNvNzpmeXP4EoMrDeTCFrxsjfwA4Hdx8iafZy3NV8tOag34nLB6Ii1b1OJ2Pp+hvme9wJBALyOFuNa7UxnPlMU48kyMMuU2oWGmQvmBpQKE0OHDkQ6zSvk8PF9xvprQammcFP5LAIdBviB4xTNS2IUL0uZygkCQFEn2I+EDiiWi5V9bBg1rEkNL9ei0Ebi0WvFEZfLnm6DKWtdxLYr426smSb41XuBLG5MYCe82jlxc35cTEC/zF0CQQD9SSUV7onYTp2om+XB2JIeTzrSQ+ME88HG9KjaheGDPIP/hQIqYXp0agAZhzW0vNabBNMqrF6M0+St59biODBa"));
        System.out.println(MD5.encode1("111111"));
        System.out.println(MD5.digest("111111"));
	}
	
}
