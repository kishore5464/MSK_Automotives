package com.msk.automotive.utilities;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class Encrypt_Decrypt {

	public static String key = "Bar12345Bar12345"; // 128 bit key
	public static String initVector = "RandomInitVector"; // 16 bytes IV

	public String encrypt(String password) {
		byte[] encrypted = null;

		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			encrypted = cipher.doFinal(password.getBytes());

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return Base64.encodeBase64String(encrypted);
	}

	public String decrypt(String password) {
		byte[] original = null;

		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			original = cipher.doFinal(Base64.decodeBase64(password));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new String(original);
	}

}