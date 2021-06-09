package com.steppins.DAO;

import com.steppins.JDBC.DataSourceConnection;

import java.util.List;

public abstract class GenericDAO <T> {

    public DataSourceConnection getDataSourceConnection()  {
        return DataSourceConnection.getInstance();
    }

    public abstract boolean create(T object);
    public abstract T read(Long id);
    public abstract List<T> readAll();
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
}
