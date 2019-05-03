package com.hong.qrcode.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryption {

    public static String getMD5Str(String str) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

}
