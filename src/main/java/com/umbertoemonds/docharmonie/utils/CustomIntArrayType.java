package com.umbertoemonds.docharmonie.utils;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class CustomIntArrayType implements UserType {

    @Override
    public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
        return null;
    }

    @Override
    public Object deepCopy(Object arg0) throws HibernateException {
        return null;
    }

    @Override
    public Serializable disassemble(Object arg0) throws HibernateException {
        return null;
    }

    @Override
    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        return arg0 == arg1;
    }

    @Override
    public int hashCode(Object arg0) throws HibernateException {
        return 0;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(ResultSet arg0, String[] arg1, SharedSessionContractImplementor arg2, Object arg3)
            throws HibernateException, SQLException {
        Array array = arg0.getArray(arg1[0]);
        return array != null ? array.getArray() : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object arg1, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (arg1 != null && st != null) {
            Array array = session.connection().createArrayOf("int", (Integer[]) arg1);
            st.setArray(index, array);
        } else {
            st.setNull(index, sqlTypes()[0]);
        }
        
    }

    @Override
    public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
        return null;
    }

    @Override
    public Class returnedClass() {
        return int[].class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }
    
}
