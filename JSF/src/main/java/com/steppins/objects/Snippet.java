package com.steppins.objects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Snippet {
    private Long snippetId;
    private String snippetTitle;
    private Long snippetAuthorId;
    private String snippetAuthor;
    private Date snippetDate;
    private String snippetCode;
    private List<Keyword> snippetKeywords;

    public Snippet(Long snippetId, String snippetTitle){}
    public Snippet(Long snippetId, String snippetTitle, Long snippetAuthorId, String snippetAuthor, Date snippetDate, String snippetCode){
        this.snippetId = snippetId;
        this.snippetTitle = snippetTitle;
        this.snippetAuthorId = snippetAuthorId;
        this.snippetAuthor = snippetAuthor;
        this.snippetDate = snippetDate;
        this.snippetCode = snippetCode;
        this.snippetKeywords = new ArrayList<Keyword>();
    }

    public void addKeyword(Keyword newKeyword){ snippetKeywords.add(newKeyword); }

    public Long getSnippetId(){ return snippetId; }
    public void setSnippetId(Long snippetId){ this.snippetId = snippetId; }
    public String getSnippetTitle(){ return snippetTitle; }
    public void setSnippetTitle(String snippetTitle){ this.snippetTitle = snippetTitle; }
    public Long getSnippetAuthorId(){ return snippetAuthorId; }
    public void setSnippetAuthorId(Long snippetAuthorId){ this.snippetAuthorId = snippetAuthorId; }
    public String getSnippetAuthor(){ return snippetAuthor; }
    public void setSnippetAuthor(String snippetAuthor){ this.snippetAuthor = snippetAuthor; }
    public Date getSnippetDate(){ return snippetDate; }
    public void setSnippetDate(Date snippetDate){ this.snippetDate = snippetDate; }
    public String getSnippetCode(){ return snippetCode; }
    public void setSnippetCode(String snippetCode){ this.snippetCode = snippetCode; }
    public List<Keyword> getSnippetKeywords(){ return snippetKeywords; }
}
