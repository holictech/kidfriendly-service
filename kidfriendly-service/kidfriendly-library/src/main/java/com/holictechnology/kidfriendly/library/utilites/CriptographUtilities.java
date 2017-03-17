package com.holictechnology.kidfriendly.library.utilites;


import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author Wesley
 *
 */
public final class CriptographUtilities implements Serializable {

    public enum TypeCriptograph {
        MD5("MD5"), SHA256("SHA-256");

        private String typeCriptograph;

        /**
         *
         */
        private TypeCriptograph(String typeCriptograph) {
            this.typeCriptograph = typeCriptograph;
        }

        /**
         * @return the typeCriptograph
         */
        public String getTypeCriptograph() {
            return typeCriptograph;
        }
    }

    private static final long serialVersionUID = 1623424675100052733L;
    private static final int SIGNUM = 1;
    private static final int RADIX = 16;
    private static final String PREFIX = "fRiEnDlY";
    private static final String SUFFIX = "KiD";

    private CriptographUtilities() {}

    /**
     * Return instance class
     * 
     * @return
     */
    public synchronized static CriptographUtilities getInstance() {
        return new CriptographUtilities();
    }

    /**
     * @param email
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String createToken(String email, String password) throws NoSuchAlgorithmException {
        return createToken(email.concat(password));
    }

    /**
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String createToken(String value) throws NoSuchAlgorithmException {
        return criptograph(PREFIX.concat(criptograph(value)).concat(SUFFIX));
    }

    /**
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String criptograph(String value) throws NoSuchAlgorithmException {
        return criptograph(value, TypeCriptograph.SHA256);
    }

    /**
     * @param value
     * @param typeCriptograph
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String criptograph(String value, TypeCriptograph typeCriptograph) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(typeCriptograph.getTypeCriptograph());
        byte [] bytes = messageDigest.digest(value.getBytes());

        return new BigInteger(SIGNUM, bytes).toString(RADIX);
    }
}
