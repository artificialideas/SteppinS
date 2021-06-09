package com.steppins.DAO;

import com.steppins.objects.Keyword;
import com.steppins.JDBC.DataSourceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KeywordDAO extends GenericDAO<Keyword>{

    @Override
    public boolean create(Keyword keyword) {
        boolean isCreated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "insert into Keyword (keyword_name) values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, keyword.getKeywordName());
            preparedStatement.execute();
            isCreated = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,null);
        }
        return isCreated;
    }

    @Override
    public Keyword read(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Keyword keyword = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Keyword where keyword_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long keywordId = resultSet.getLong("keyword_id");
                String keywordName = resultSet.getString("keyword_name");
                keyword = new Keyword(keywordId, keywordName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,resultSet);
        }
        return keyword;
    }

    @Override
    public List<Keyword> readAll()  {
        List<Keyword> keywords = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Keyword";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long keywordId = resultSet.getLong("keyword_id");
                String keywordName = resultSet.getString("keyword_name");
                String colorCode = resultSet.getString("keyword_color");
                Keyword keyword = new Keyword(keywordId, keywordName, colorCode);
                keywords.add(keyword);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, statement,resultSet);
        }
        return keywords;
    }

    @Override
    public boolean update(Keyword keyword) {
        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "update Keyword set keyword_name =? where keyword_id =? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, keyword.getKeywordId());
            preparedStatement.setString(2, keyword.getKeywordName());
            preparedStatement.execute();
            isUpdated = true;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            dataSourceConnection.close (connection, preparedStatement,null);
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Keyword keyword) {
        boolean isDeleted = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "delete from Keyword where keyword_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, keyword.getKeywordId());
            preparedStatement.execute();
            isDeleted = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,null);
        }
        return isDeleted;
    }
}
