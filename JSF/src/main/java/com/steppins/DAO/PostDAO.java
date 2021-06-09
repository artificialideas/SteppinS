package com.steppins.DAO;

import com.steppins.objects.Post;
import com.steppins.JDBC.DataSourceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends GenericDAO<Post>{

    @Override
    public boolean create(Post post) {
        boolean isCreated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "insert into Post (post_title) values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getPostTitle());
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
    public Post read(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Post post = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Post where post_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long postId = resultSet.getLong("post_id");
                String postTitle = resultSet.getString("post_title");
                Long postAuthorId = resultSet.getLong("author_id");
                Date postDate = resultSet.getDate("post_timestamp");
                String postCode = resultSet.getString("post_code");
                String postDescription = resultSet.getString("post_description");
                String postOutput = resultSet.getString("post_output");
                String postSource = resultSet.getString("post_source");

                post = new Post(postId, postTitle, postAuthorId, postDate, postCode, postDescription, postOutput, postSource);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,resultSet);
        }
        return post;
    }

    @Override
    public List<Post> readAll()  {
        List<Post> posts = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from Post";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long postId = resultSet.getLong("post_id");
                String postTitle = resultSet.getString("post_title");
                Long postAuthorId = resultSet.getLong("author_id");
                Date postDate = resultSet.getDate("post_timestamp");
                String postCode = resultSet.getString("post_code");
                String postDescription = resultSet.getString("post_description");
                String postOutput = resultSet.getString("post_output");
                String postSource = resultSet.getString("post_source");
                Post post = new Post(postId, postTitle, postAuthorId, postDate, postCode, postDescription, postOutput, postSource);
                posts.add(post);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, statement,resultSet);
        }
        return posts;
    }

    @Override
    public boolean update(Post post) {
        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "update Post set post_title =?, post_timestamp =?, post_code =?, post_output =?, post_description =?, post_source =? where post_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, post.getPostId());
            preparedStatement.setString(2, post.getPostTitle());
            preparedStatement.setDate(3, (Date) post.getPostDate());
            preparedStatement.setString(4, post.getPostCode());
            preparedStatement.setString(5, post.getPostOutput());
            preparedStatement.setString(6, post.getPostDescription());
            preparedStatement.setString(7, post.getPostSource());
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
    public boolean delete(Post post) {
        boolean isDeleted = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "delete from Post where post_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, post.getPostId());
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
