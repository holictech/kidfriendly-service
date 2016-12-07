package com.holictechnology.kidfriendly.library.hibernate;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.BasicType;
import org.hibernate.type.TypeResolver;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;


@SuppressWarnings("rawtypes")
public final class EnumUserType implements UserType, ParameterizedType {

    public static final String PACKAGE_ENUM = "packageEnum";
    public static final String GET_VALUE_METHOD = "getValueMethod";
    public static final String VALUE_OF_METHOD = "valueOfMethod";
    private static final String DEFAULT_GET_VALUE_METHOD = "getValue";
    private static final String DEFAULT_VALUE_OF_METHOD = "valueOf";

    private int [] sqlTypes = null;
    private Class<? extends Enum> enumClass = null;
    private Method getValueMethod = null;
    private BasicType basicType = null;
    private Method valueOfMethod = null;

    @Override
    public void setParameterValues(Properties parameters) {
        String packageEnum = parameters.getProperty(PACKAGE_ENUM);

        try {
            enumClass = Class.forName(packageEnum).asSubclass(Enum.class);
        } catch (ClassNotFoundException exception) {
            throw new HibernateException("Enum class not found.", exception);
        }

        String getValueMethodName = parameters.getProperty(GET_VALUE_METHOD, DEFAULT_GET_VALUE_METHOD);

        try {
            getValueMethod = enumClass.getMethod(getValueMethodName, new Class[BigInteger.ZERO.intValue()]);
        } catch (Exception exception) {
            throw new HibernateException("Failed to obtain value method.", exception);
        }

        basicType = new TypeResolver().basic(getValueMethod.getReturnType().getName());
        sqlTypes = basicType.sqlTypes(null);

        String valueOfMethodName = parameters.getProperty(VALUE_OF_METHOD, DEFAULT_VALUE_OF_METHOD);

        try {
            valueOfMethod = enumClass.getMethod(valueOfMethodName, new Class[] {
                    getValueMethod.getReturnType()
            });
        } catch (Exception exception) {
            throw new HibernateException("Failed to obtain 'valueOf' method.", exception);
        }
    }

    @Override
    public int [] sqlTypes() {
        return sqlTypes;
    }

    @Override
    public Class returnedClass() {
        return enumClass;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String [] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        Object value = basicType.nullSafeGet(rs, names, session, owner);

        if (value != null) {
            try {
                return valueOfMethod.invoke(enumClass, new Object[] {
                        value
                });
            } catch (Exception exception) {
                throw new HibernateException("Exception while invoking valueOf method '" + valueOfMethod.getName() + "' of " + "enumeration class '"
                        + enumClass + "'", exception);

            }
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, sqlTypes[BigInteger.ZERO.intValue()]);
        } else {
            try {
                basicType.nullSafeSet(st, getValueMethod.invoke(value, new Object[BigInteger.ZERO.intValue()]), index, session);
            } catch (Exception exception) {
                throw new HibernateException("Exception while invoking value '" + getValueMethod.getName() + "' of " + "enumeration class '"
                        + enumClass + "'", exception);

            }
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return Boolean.FALSE;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
