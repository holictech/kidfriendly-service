package com.holictechnology.kidfriendly.library.utilites;


import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;


public final class ArrayUtilites implements Serializable {

    private static final long serialVersionUID = 218461799210063403L;

    private ArrayUtilites() {}

    /**
     * @param object
     * @param position
     * @return
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T [] removeItem(final T [] object, final int position) {
        if (object != null) {
            List<T> list = new LinkedList<T>(Arrays.asList(object));
            int size = list.size();

            for (int index = 0; index < size; index++) {
                if (position == index) {
                    list.remove(position);
                    break;
                }
            }

            return list.toArray((T []) Array.newInstance(object.getClass().getComponentType(), list.size()));
        }

        return object;
    }

    /**
     * @param url
     * @return
     */
    public static byte [] converter(String url) {
        byte [] bytes = null;

        if (ObjectUtilities.isNotEmptyOrNull(url)) {
            try {
                URL _url = new URL(url);
                InputStream inputStream = _url.openStream();
                bytes = IOUtils.toByteArray(inputStream);
            } catch (IOException e) {}
        }

        return bytes;
    }
}
