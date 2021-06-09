package com.steppins.JDBC;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataSourceConnection {

    private static DataSourceConnection instance;
    private DataSource dataSource;
    private final static String JNDI_NAME = "java:comp/env/jdbc/SteppinS";

    // Pattern Singleton
    public static DataSourceConnection getInstance(){
        if(instance == null){
            try {
                instance = new DataSourceConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    private DataSourceConnection() throws Exception{
        dataSource = getDataSource();
    }

    public DataSource getDataSource() throws NamingException {
        Context context = new InitialContext();
        DataSource myDataSource = (DataSource) context.lookup(JNDI_NAME);
        return myDataSource;
    }


    public Connection getConnection()  {

        Connection theConn = null;
        try {
            theConn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return theConn;
    }
    public void close(Connection theConn, Statement theStmt, ResultSet theRs) {

        try {
            if (theRs != null) {
                theRs.close();
            }

            if (theStmt != null) {
                theStmt.close();
            }

            if (theConn != null) {
                theConn.close();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
