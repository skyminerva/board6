package com.board.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class BoardUtill {
	
	// sha512 crypto
	public static String generate(String str) throws NoSuchAlgorithmException{
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(str.getBytes());
	    byte[] digest = md.digest();
	    String result = new BigInteger(1, digest).toString(16).toUpperCase();
	    return result;
	}
	
    public static String alg = "AES/CBC/PKCS5Padding";
    // 키의 값 설정 aes256은 32byte 128은 16byte. 암복호화시 사용할 키 값. 노출되어서는 안되는 값.
    private final String key = "01234567890123456789012345678901";
//    							P/LTo8Ww2FniBKC7deYuzy7bH3DjULD1HoUxvIcWhr8=
    // aes128 은 16byte aes256은 32byte 시크릿key 길이 설정
    // key를 substring 16자리까지면 128, 32자리까지면 256
    private final String iv = key.substring(0, 16); // 16byte
	
    // aes 암호화
    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
    // aes 복호화
    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
    
	public static String AddDate(String strDate, int year, int month, int day) throws Exception {
		
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        
		Calendar cal = Calendar.getInstance();
        
		Date dt = dtFormat.parse(strDate);
        
		cal.setTime(dt);
        
		cal.add(Calendar.YEAR,  year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DATE,  day);
        
		return dtFormat.format(cal.getTime());
	}
}
