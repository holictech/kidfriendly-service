package com.holictechnology.kidfriendly.library.utilites;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public final class ReflectionUtilites implements Serializable {

    private static final long serialVersionUID = -8234969027302168443L;
    private static final String GET = "get";
    private static final String SET = "set";

    private ReflectionUtilites() {}

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T newInstance(Class<T> clazz) throws Exception {
        isNull(clazz);
        T object = null;

        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
            error(e);
        } catch (IllegalAccessException e) {
            error(e);
        }

        return object;
    }

    /**
     * @param className
     * @return
     * @throws Exception
     */
    public static Object newInstance(String className) throws Exception {
        isNull(className);
        Object object = null;

        try {
            object = newInstance(Class.forName(className));
        } catch (ClassNotFoundException e) {
            error(e);
        }

        return object;
    }

    /**
     * @param object
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Field getDeclaredField(Object object, String fieldName) throws Exception {
        isNull(object, fieldName);

        return getDeclaredField(object, object.getClass(), fieldName);
    }

    /**
     * @param object
     * @param clazz
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Field getDeclaredField(Object object, Class<?> clazz, String fieldName) throws Exception {
        isNull(object, clazz, fieldName);

        if (clazz.isAssignableFrom(Object.class)) {
            error("Attribute[" + fieldName + "] not found.");
        }

        Field field;

        try {
            field = clazz.getDeclaredField(getDeclaredFieldName(clazz, fieldName));
        } catch (NoSuchFieldException e) {
            field = getDeclaredField(object, clazz.getSuperclass(), fieldName);
        }

        if (!isPublic(field)) {
            setAccessible(field);
        }

        return field;
    }

    /**
     * @param object
     * @param fieldName
     * @param value
     * @throws Exception
     */
    public static void set(Object object, String fieldName, Object value) throws Exception {
        isNull(object, fieldName);

        set(object, getDeclaredField(object, fieldName), value);
    }

    /**
     * @param object
     * @param field
     * @param value
     * @throws Exception
     */
    public static void set(Object object, Field field, Object value) throws Exception {
        isNull(object, field);

        if (!field.isAccessible()) {
            setAccessible(field);
        }

        try {
            field.set(object, cast(field.getType(), value));
        } catch (IllegalArgumentException e) {
            error(e);
        } catch (IllegalAccessException e) {
            error(e);
        }
    }

    /**
     * @param object
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Object get(Object object, String fieldName) throws Exception {
        isNull(object, fieldName);

        return get(object, getDeclaredField(object, fieldName));
    }

    /**
     * @param object
     * @param field
     * @return
     * @throws Exception
     */
    public static Object get(Object object, Field field) throws Exception {
        isNull(object, field);

        if (!field.isAccessible()) {
            setAccessible(field);
        }

        Object value = null;

        try {
            value = field.get(object);
        } catch (IllegalArgumentException e) {
            error(e);
        } catch (IllegalAccessException e) {
            error(e);
        }

        return value;
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static boolean isCreateNewInstance(Class<?> clazz) throws Exception {
        isNull(clazz);

        return !(isArray(clazz) || isBoolean(clazz) || isChar(clazz) || isDate(clazz) || isNumber(clazz) || isString(clazz));
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> newListInstance(Class<T> clazz) throws Exception {
        isNull(clazz);

        return new LinkedList<T>();
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> Set<T> newSetInstance(Class<T> clazz) throws Exception {
        isNull(clazz);

        return new TreeSet<T>();
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static boolean isCollection(Class<?> clazz) throws Exception {
        isNull(clazz);

        return Collection.class.isAssignableFrom(clazz);
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static boolean isList(Class<?> clazz) throws Exception {
        isNull(clazz);

        return List.class.isAssignableFrom(clazz);
    }

    /**
     * @param clazz
     * @return
     * @throws Exception
     */
    public static boolean isSet(Class<?> clazz) throws Exception {
        isNull(clazz);

        return Set.class.isAssignableFrom(clazz);
    }

    /**
     * @param object
     * @param annotationClass
     * @return
     * @throws Exception
     */
    public static boolean isAnnotationPresent(Object object, Class<? extends Annotation> annotationClass) throws Exception {
        isNull(object, annotationClass);

        return object.getClass().isAnnotationPresent(annotationClass);
    }

    /**
     * @param accessibleObject
     * @param annotationClass
     * @return
     * @throws Exception
     */
    public static boolean isAnnotationPresent(AccessibleObject accessibleObject, Class<? extends Annotation> annotationClass) throws Exception {
        isNull(accessibleObject, annotationClass);

        return accessibleObject.isAnnotationPresent(annotationClass);
    }

    /**
     * @param object
     * @param annotationClass
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <A extends Annotation> A getAnnotation(Object object, Class<? extends Annotation> annotationClass) throws Exception {
        isNull(object, annotationClass);

        return (A) object.getClass().getAnnotation(annotationClass);
    }

    /**
     * @param accessibleObject
     * @param annotationClass
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <A extends Annotation> A getAnnotation(AccessibleObject accessibleObject, Class<? extends Annotation> annotationClass)
            throws Exception {
        isNull(accessibleObject, annotationClass);

        return (A) accessibleObject.getAnnotation(annotationClass);
    }

    /**
     * @param object
     * @return
     * @throws Exception
     */
    public static List<Field> getDeclaredField(Object object) throws Exception {
        isNull(object);
        List<Field> listField = new LinkedList<Field>();
        Class<?> clazz = object.getClass();

        do {
            for (Field field : clazz.getDeclaredFields()) {
                if (!(isStatic(field) && isFinal(field))) {
                    listField.add(field);

                    if (!isPublic(field)) {
                        setAccessible(field);
                    }
                }
            }

            clazz = (Class<?>) clazz.getSuperclass();
        } while (!clazz.isAssignableFrom(Object.class));

        return listField;
    }

    /**
     * @param object
     * @param annotationClass
     * @return
     * @throws Exception
     */
    public static List<Field> getDeclaredField(Object object, Class<? extends Annotation> annotationClass) throws Exception {
        isNull(object, annotationClass);
        List<Field> listField = new LinkedList<Field>();

        for (Field field : getDeclaredField(object)) {
            if (isAnnotationPresent(field, annotationClass)) {
                listField.add(field);
            }
        }

        return listField;
    }

    /**
     * @param type
     * @return
     * @throws Exception
     */
    public static Type getGenericType(Type type) throws Exception {
        isNull(type);

        if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            isNull(parameterizedType);
            Type [] arrayType = parameterizedType.getActualTypeArguments();

            if (arrayType != null) {
                return arrayType[BigInteger.ZERO.intValue()];
            } else {
                error("Null parameter(s).");
            }
        }

        return null;
    }

    /**
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static String createMethodGet(String fieldName) throws Exception {
        isNull(fieldName);

        return GET.concat(createMethodGetSet(fieldName));
    }

    /**
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static String createMethodSet(String fieldName) throws Exception {
        isNull(fieldName);

        return SET.concat(createMethodGetSet(fieldName));
    }

    /**
     * @param object
     * @param methodName
     * @return
     * @throws Exception
     */
    public static Object invoke(Object object, String methodName) throws Exception {
        isNull(object, methodName);

        return getDeclaredMethod(object.getClass(), methodName).invoke(object);
    }

    /**
     * @param object
     * @param methodName
     * @param parameters
     * @return
     * @throws Exception
     */
    public static Object invoke(Object object, String methodName, Object ... parameters) throws Exception {
        isNull(object, methodName);
        Object invoke = null;

        if (parameters == null || parameters.length == BigInteger.ZERO.intValue()) {
            invoke = invoke(object, methodName);
        } else {
            List<Class<?>> list = new LinkedList<Class<?>>();

            for (Object parameter : parameters) {
                list.add(parameter.getClass());
            }

            invoke = getDeclaredMethod(object.getClass(), methodName, list.toArray(new Class[list.size()])).invoke(object, parameters);
        }

        return invoke;
    }

    /**
     * @param clazz
     * @param methodName
     * @return
     * @throws Exception
     */
    public static Method getDeclaredMethod(Class<?> clazz, String methodName) throws Exception {
        Method method = null;

        if (clazz.isAssignableFrom(Object.class)) {
            error("Method[" + methodName + "] not found.");
        }

        try {
            method = clazz.getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            method = getDeclaredMethod(clazz.getSuperclass(), methodName);
        }

        if (!isPublic(method)) {
            setAccessible(method);
        }

        return method;
    }

    /**
     * @param clazz
     * @param methodName
     * @param parameters
     * @return
     * @throws Exception
     */
    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?> ... parameters) throws Exception {
        Method method = null;

        if (clazz.isAssignableFrom(Object.class)) {
            error("Method[" + methodName + "] not found.");
        }

        try {
            method = clazz.getDeclaredMethod(methodName, parameters);
        } catch (NoSuchMethodException e) {
            method = getDeclaredMethod(clazz.getSuperclass(), methodName, parameters);
        }

        if (!isPublic(method)) {
            setAccessible(method);
        }

        return method;
    }

    private static boolean isPublic(Member member) throws Exception {
        return Modifier.isPublic(member.getModifiers());
    }

    private static boolean isStatic(Member member) throws Exception {
        return Modifier.isStatic(member.getModifiers());
    }

    private static boolean isFinal(Member member) throws Exception {
        return Modifier.isFinal(member.getModifiers());
    }

    private static void setAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(Boolean.TRUE);
    }

    private static String getDeclaredFieldName(Class<?> clazz, String fieldName) throws Exception {
        String returnFieldName = null;

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().toUpperCase().equals(fieldName.toUpperCase())) {
                returnFieldName = field.getName();
                break;
            }
        }

        return ((returnFieldName == null) ? fieldName : returnFieldName);
    }

    @SuppressWarnings("unchecked")
    private static <T> T cast(Class<T> clazz, Object value) throws Exception {
        T object = null;

        if (isNumber(clazz)) {
            object = castNumber(clazz, value);
        } else if (isBoolean(clazz)) {
            object = castBoolean(clazz, value);
        } else if (isChar(clazz)) {
            object = castChar(clazz, value);
        } else {
            object = (T) value;
        }

        return object;
    }

    @SuppressWarnings("unchecked")
    private static <T> T castNumber(Class<T> clazz, Object value) throws Exception {
        T object = null;

        if (value != null) {
            if (BigDecimal.class.isAssignableFrom(clazz)) {
                object = (T) new BigDecimal(value.toString());
            } else if (BigInteger.class.isAssignableFrom(clazz)) {
                object = (T) new BigInteger(value.toString());
            } else if (byte.class.isAssignableFrom(clazz) || Byte.class.isAssignableFrom(clazz)) {
                object = (T) Byte.valueOf(value.toString());
            } else if (double.class.isAssignableFrom(clazz) || Double.class.isAssignableFrom(clazz)) {
                object = (T) Double.valueOf(value.toString());
            } else if (float.class.isAssignableFrom(clazz) || Float.class.isAssignableFrom(clazz)) {
                object = (T) Float.valueOf(value.toString());
            } else if (int.class.isAssignableFrom(clazz) || Integer.class.isAssignableFrom(clazz)) {
                object = (T) Integer.valueOf(value.toString());
            } else if (long.class.isAssignableFrom(clazz) || Long.class.isAssignableFrom(clazz)) {
                object = (T) Long.valueOf(value.toString());
            } else if (short.class.isAssignableFrom(clazz) || Short.class.isAssignableFrom(clazz)) {
                object = (T) Short.valueOf(value.toString());
            }
        }

        return (T) ((clazz.isPrimitive() && object == null) ? BigInteger.ZERO.byteValue() : object);
    }

    @SuppressWarnings("unchecked")
    private static <T> T castBoolean(Class<T> clazz, Object value) throws Exception {
        T object = null;

        if (value != null) {
            object = (T) ((isNumber(value.getClass()) ? (Boolean.valueOf(value.equals(BigInteger.ONE.intValue()) ? "True" : "False")) : Boolean.valueOf(value
                    .toString())));
        }

        return (T) ((clazz.isPrimitive() && object == null) ? Boolean.FALSE : object);
    }

    @SuppressWarnings("unchecked")
    private static <T> T castChar(Class<T> clazz, Object value) throws Exception {
        T object = null;

        if (value != null) {
            object = (T) Character.valueOf(value.toString().charAt(BigInteger.ZERO.intValue()));
        }

        return (T) ((clazz.isPrimitive() && object == null) ? ' ' : object);
    }

    private static boolean isNumber(Class<?> clazz) {
        return byte.class.isAssignableFrom(clazz) || double.class.isAssignableFrom(clazz) || float.class.isAssignableFrom(clazz)
                || int.class.isAssignableFrom(clazz) || long.class.isAssignableFrom(clazz) || short.class.isAssignableFrom(clazz)
                || Number.class.isAssignableFrom(clazz);
    }

    private static boolean isBoolean(Class<?> clazz) {
        return boolean.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz);
    }

    private static boolean isChar(Class<?> clazz) {
        return char.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz);
    }

    private static boolean isDate(Class<?> clazz) {
        return Date.class.isAssignableFrom(clazz);
    }

    private static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }

    private static boolean isString(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    private static void isNull(Object ... args) throws Exception {
        boolean isNull = true;

        if (args != null) {
            for (Object object : args) {
                isNull = !(object != null);
            }
        }

        if (isNull) {
            error("Null parameter(s).");
        }
    }

    private static String createMethodGetSet(String fieldName) throws Exception {
        return String.valueOf(fieldName.charAt(BigInteger.ZERO.intValue())).toUpperCase().concat(fieldName.substring(BigInteger.ONE.intValue()));
    }

    private static void error(final String message) throws Exception {
        error(new Exception(message));
    }

    private static void error(final Exception exception) throws Exception {
        throw exception;
    }
}
