package com.board.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class AesCrypto {
	
	private SecretKeySpec secretKey;

	public AesCrypto(String reqSecretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		//바이트 배열로부터 SecretKey를 구축
		this.secretKey = new SecretKeySpec(reqSecretKey.getBytes("UTF-8"), "AES");
	}
	

    //AES ECB PKCS5Padding 암호화(Hex | Base64)
   	public String AesECBEncode(String plainText) throws Exception {
		
		//Cipher 객체 인스턴스화(Java에서는 PKCS#5 = PKCS#7이랑 동일)
		Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		//Cipher 객체 초기화
		c.init(Cipher.ENCRYPT_MODE, secretKey);
		
		//Encrpytion/Decryption
		byte[] encrpytionByte = c.doFinal(plainText.getBytes("UTF-8"));
		
		//Hex Encode
		return Hex.encodeHexString(encrpytionByte);
		
		//Base64 Encode
//		return Base64.encodeBase64String(encrpytionByte);
	}


    //AES ECB PKCS5Padding 복호화(Hex | Base64)
	public String AesECBDecode(String encodeText) throws Exception {

		//Cipher 객체 인스턴스화(Java에서는 PKCS#5 = PKCS#7이랑 동일)
		Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		//Cipher 객체 초기화
		c.init(Cipher.DECRYPT_MODE, secretKey);
		
		//Decode Hex
		byte[] decodeByte = Hex.decodeHex(encodeText.toCharArray());
		
		//Decode Base64
//		byte[] decodeByte = Base64.decodeBase64(encodeText);
		
		return new String(c.doFinal(decodeByte), "UTF-8");
	}

}


