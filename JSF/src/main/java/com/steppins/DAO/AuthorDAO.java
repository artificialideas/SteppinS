package com.steppins.DAO;

import com.steppins.objects.Author;
import com.steppins.JDBC.DataSourceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO extends GenericDAO<Author>{

    @Override
    public boolean create(Author author) {
        boolean isCreated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "insert into Author (author_name) values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthorName());
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
    public Author read(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Author author = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Author where author_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Long authorId = resultSet.getLong("author_id");
                String authorName = resultSet.getString("author_name");
                author = new Author(authorId, authorName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,resultSet);
        }
        return author;
    }

    @Override
    public List<Author> readAll()  {
        List<Author> authors = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Author";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long authorId = resultSet.getLong("author_id");
                String authorName = resultSet.getString("author_name");
                String authorEmail = resultSet.getString("author_email");
                String authorPwd = resultSet.getString("author_password");
                Author author = new Author(authorId, authorName, authorEmail, authorPwd);
                authors.add(author);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, statement,resultSet);
        }
        return authors;
    }

    @Override
    public boolean update(Author author) {
        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "update Author set author_name =?, author_email =?, author_password =? where author_id =? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthorName());
            preparedStatement.setLong(2, author.getAuthorId());
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
    public boolean delete(Author author) {
        boolean isDeleted = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "delete from Author where author_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, author.getAuthorId());
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
