package com.steppins.DAO;

import com.steppins.objects.*;

public class DAOFactory {
    public static GenericDAO<Author> authorDAO(){ return new AuthorDAO(); }
    public static GenericDAO<Keyword> keywordDAO(){
        return new KeywordDAO();
    }
    public static GenericDAO<Post> postDAO(){
        return new PostDAO();
    }
    public static GenericDAO<Snippet> snippetDAO(){
        return new SnippetDAO();
    }
}