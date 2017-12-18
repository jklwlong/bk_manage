package com.gr.bk.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 * @ClassName: MD5
 * @Author
 * @Date
 * @Modify
 */
public class MD5 {
  public static final int LENGTH_16 = 16;
  public static final int LENGTH_32 = 32;

  public static String encode(String s, int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    byte[] md5Bytes = md5.digest(s.getBytes("utf-8"));
    StringBuffer hexValue = new StringBuffer();
    for (int i = 0; i < md5Bytes.length; i++) {
      int val = md5Bytes[i] & 0xFF;
      if (val < 16) {
        hexValue.append("0");
      }
      hexValue.append(Integer.toHexString(val));
    }
    if (length == 32) {
      return hexValue.toString();
    }
    return hexValue.toString().substring(8, 24);
  }

}