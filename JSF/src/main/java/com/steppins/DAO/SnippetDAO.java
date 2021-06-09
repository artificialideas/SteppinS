package com.steppins.DAO;

import com.steppins.objects.Keyword;
import com.steppins.objects.Snippet;
import com.steppins.JDBC.DataSourceConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SnippetDAO extends GenericDAO<Snippet>{

    @Override
    public Snippet read(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Snippet snippet = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from vw_snippet where post_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long snippetId = resultSet.getLong("post_id");
                String snippetTitle = resultSet.getString("post_title");
                snippet = new Snippet(snippetId, snippetTitle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, preparedStatement,resultSet);
        }
        return snippet;
    }

    @Override
    public List<Snippet> readAll()  {
        List<Snippet> snippets = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        DataSourceConnection dataSourceConnection = getDataSourceConnection();
        try {
            connection = getDataSourceConnection().getConnection();
            String sql = "select * from vw_snippet ORDER BY post_id";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            Snippet snippet = new Snippet(-1L,null);

            while (resultSet.next()) {
                Long snippetId = resultSet.getLong("post_id");

                if (snippets.size() == 0 || snippets.get(snippets.size()-1).getSnippetId() != snippetId) {
                    String snippetTitle = resultSet.getString("post_title");
                    Long snippetAuthorId = resultSet.getLong("author_id");
                    String snippetAuthor = resultSet.getString("author_name");
                    Date snippetDate = resultSet.getDate("post_timestamp");
                    String snippetCode = resultSet.getString("post_code");

                    snippet = new Snippet(snippetId, snippetTitle, snippetAuthorId, snippetAuthor, snippetDate, snippetCode);
                    snippets.add(snippet);
                }

                Long snippetKeywordId = resultSet.getLong("keyword_id");
                String snippetKeywordName = resultSet.getString("keyword_name");
                String snippetKeywordColor = resultSet.getString("keyword_color");

                Keyword keyword = new Keyword(snippetKeywordId, snippetKeywordName, snippetKeywordColor);
                snippet.addKeyword(keyword);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataSourceConnection.close (connection, statement,resultSet);
        }
        return snippets;
    }

    @Override
    public boolean create(Snippet object) { return false; }
    @Override
    public boolean update(Snippet object) { return false; }
    @Override
    public boolean delete(Snippet object) { return false; }
}
