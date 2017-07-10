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
        if (isNotEmptyOrNull(s)) {
            try {
                s = new String(s.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {}
        }

        return s;
    }
}
