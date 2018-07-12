package com.news.rec.service;

import javax.crypto.Cipher;

public class CryptService {
	/**client encry secret key*/
	private static final String secretkey="board";
	
	public static String sign(String content){
		String md5str=CryptUtil.convertToMd5(content);
		return encrypt(md5str);
	}
    
	public static String encrypt(String content){
		try {
			return CryptUtil.base64Encode(CryptUtil.aesCrypt3(Cipher.ENCRYPT_MODE,content.getBytes("utf-8"), secretkey.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
	public static String decrypt(String content){
		try {
			return new String(CryptUtil.aesCrypt3(Cipher.DECRYPT_MODE,CryptUtil.base64Decode(content), secretkey.getBytes("utf-8")),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
//		long ts=1471070364000L;
		System.out.println("devId: "+encrypt("liudaax@126.com"));
		String devId=decrypt("oMtMiYwp+tY1Uk51VYEz8w==");
//		String res="WWU3Uf5OaAa7DV9xwsioiAs78vmJ48bV/KpeKoIBVOt48ErR02zJ6/KXOnxX046I";
//		String res="G+lbdzsS52VJLF925yi0u0mYNesIp6ywr44OEX8F01B48ErR02zJ6/KXOnxX046I";
//		String result=sign(devId+ts);
		System.out.println("devId:"+devId);
//		System.out.println("result:"+result);
//		System.out.println(result.equals(res));
//		System.out.println("devId: "+decrypt("Dt+mzpqV/nPLM8lRmCfZjmky78hX9GWUORHAJV2yIy9lPmofkpDK0j+JLcBuR1pX"));
	}
}
