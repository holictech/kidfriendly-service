package com.holictechnology.kidfriendly.library.utilites;


import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public final class CriptographUtilites implements Serializable {

    private static final long serialVersionUID = 1623424675100052733L;
    private static final String SUFFIX = "KiD";
    private static final String PREFIX = "fRiEnDlY";

    private CriptographUtilites() {}

    /**
     * Return instance class
     * 
     * @return
     */
    public static CriptographUtilites getInstance() {
        return new CriptographUtilites();
    }

    /**
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String createToken(String str) throws NoSuchAlgorithmException {
        return PREFIX.concat(criptograph(str)).concat(SUFFIX);
    }

    public String criptograph(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte [] criptograph = messageDigest.digest(str.getBytes());

        return new BigInteger(1, criptograph).toString(16);
    }
}
