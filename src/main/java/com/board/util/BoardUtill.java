package com.board.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BoardUtill {
	
	// sha512 crypto
	public static String generate(String str) throws NoSuchAlgorithmException{
	    MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(str.getBytes());
	    byte[] digest = md.digest();
	    String result = new BigInteger(1, digest).toString(16).toUpperCase();
	    System.out.println(result);
	    return result;
	}

}
