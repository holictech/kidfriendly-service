package com.holictechnology.kidfriendly.library.utilites;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collection;


public final class ObjectUtilities implements Serializable {

    private static final long serialVersionUID = 1805562204084686619L;

    private ObjectUtilities() {}

    /**
     * @param s
     *            - {@link String}
     * @return
     */
    public static boolean isEmptyOrNull(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * @param s
     *            - {@link String}
     * @return
     */
    public static boolean isNotEmptyOrNull(String s) {
        return !isEmptyOrNull(s);
    }

    /**
     * @param c
     *            - {@link Collection}
     * @return
     */
    public static boolean isEmptyOrNull(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    /**
     * @param c
     *            - {@link Collection}
     * @return
     */
    public static boolean isNotEmptyOrNull(Collection<?> c) {
        return !isEmptyOrNull(c);
    }

    /**
     * @param s
     *            {@link String}
     * @return
     */
    public static String utf8(String s) {
        return conveterCharset(s, "UTF-8");
    }

    /**
     * @param s
     *            {@link String}
     * @return
     */
    public static String iso88591(String s) {
        return conveterCharset(s, "ISO-8859-1");
    }

    private static String conveterCharset(String s, final String charSet) {
        if (isNotEmptyOrNull(s)) {
            try {
                s = new String(s.getBytes(charSet));
            } catch (UnsupportedEncodingException e) {}
        }
        return s;
    }
}
