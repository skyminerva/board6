package com.board.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AesCrypto {
	
	
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
    // 암복호화 확인
    public static void main(String[] args) throws Exception {
    	// 암호화 생성
    	AesCrypto aesCrypto = new AesCrypto();
    	
    	AesCrypto aescry = new AesCrypto();
    	// 암호화 대상 문자열
        String text = "!! Hello World !!";
        // 대상 aes 암호화
        String cipherText = aesCrypto.encrypt(text);
        
        String reText = aescry.decrypt(cipherText);
        // 대상
        System.out.println(text);
        // 암호화 결과
        System.out.println(cipherText);
        // 복호화 
        System.out.println(reText);

    }


}




