package com.steppins.controller;

import com.steppins.DAO.DAOFactory;
import com.steppins.objects.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class PostController implements Serializable{
    /* Snippets list - VIEW table */
    private Long snippetId;
    private String snippetTitle;
    private String snippetAuthor;
    private Date snippetDate;
    private String snippetCode;
    private Long snippetKeywordId;
    private String snippetKeywordName;
    private String snippetKeywordColor;
    private List<Snippet> snippetList;

    /* Criteria search */
    private Author selectedAuthor;
    private List<Author> authorList;
    private Post selectedPost;
    private List<Post> postList;
    private Keyword selectedKeywords;
    private List<Keyword> keywordList;
    private final static Long DEFAULT_ID = -1L;

    @PostConstruct
    public void init(){
        initSnippetList();
        //initKeywordList();
    }
    public void initSnippetList(){
        snippetList = DAOFactory.snippetDAO().readAll();
    }
    /*public List<Keyword> initKeywordList(){
        keywordList = DAOFactory.keywordDAO().readAll();
        return keywordList;
    }*/

    /* Getters and setters */
    public Long getSnippetId(){ return snippetId; }
    public void setSnippetId(Long snippetId){ this.snippetId = snippetId; }
    public String getSnippetTitle(){ return snippetTitle; }
    public void setSnippetTitle(String snippetTitle){ this.snippetTitle = snippetTitle; }
    public String getSnippetAuthor(){ return snippetAuthor; }
    public void setSnippetAuthor(String snippetAuthor){ this.snippetAuthor = snippetAuthor; }
    public Date getSnippetDate(){ return snippetDate; }
    public void setSnippetDate(Date snippetDate){ this.snippetDate = snippetDate; }
    public String getSnippetCode(){ return snippetCode; }
    public void setSnippetCode(String snippetCode){ this.snippetCode = snippetCode; }
    public Long getSnippetKeywordId(){ return snippetKeywordId; }
    public void setSnippetKeywordId(Long snippetKeywordId){ this.snippetKeywordId = snippetKeywordId; }
    public String getSnippetKeywordName(){ return snippetKeywordName; }
    public void setSnippetKeywordName(String snippetKeywordName){ this.snippetKeywordName = snippetKeywordName; }
    public String getSnippetKeywordColor(){ return snippetKeywordColor; }
    public void setSnippetKeywordColor(String snippetKeywordColor){ this.snippetKeywordColor = snippetKeywordColor; }
    public List<Snippet> getSnippetList(){ return snippetList; }
    public void setSnippetList(List<Snippet> snippetList){ this.snippetList = snippetList; }

    public Author getSelectedAuthor(){ return selectedAuthor; }
    public void setSelectedAuthor(Author selectedAuthor){ this.selectedAuthor = selectedAuthor; }
    public List<Author> getAuthorList(){ return authorList; }
    public void setAuthorList(List<Author> authorList){ this.authorList = authorList; }
    public Post getSelectedPost(){ return selectedPost; }
    public void setSelectedPost(Post selectedPost){ this.selectedPost = selectedPost; }
    public List<Post> getPostList(){ return postList; }
    public void setPostList(List<Post> postList){ this.postList = postList; }
    public Keyword getSelectedKeywords(){ return selectedKeywords; }
    public void setSelectedKeywords(Keyword selectedKeywords){ this.selectedKeywords = selectedKeywords; }
    public List<Keyword> getKeywordList(){ return keywordList; }
    public void setKeywordList(List<Keyword> keywordList){ this.keywordList = keywordList; }
}