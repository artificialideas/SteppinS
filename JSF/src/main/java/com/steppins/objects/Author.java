package com.steppins.objects;

public class Author {
    private Long authorId;
    private String authorName;
    private String authorEmail;
    private String authorPwd;

    public Author(Long authorId, String authorName){}

    public Author(Long authorId, String authorName, String authorEmail, String authorPwd){
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorPwd = authorPwd;
    }

    //Getters and setters
    public Long getAuthorId(){ return authorId; }
    public void setAuthorId(Long authorId){ this.authorId = authorId; }
    public String getAuthorName(){ return authorName; }
    public void setAuthorName(String authorName){ this.authorName = authorName; }
    public String getAuthorEmail(){ return authorEmail; }
    public void setAuthorEmail(String authorEmail){ this.authorEmail = authorEmail; }
    public String getAuthorPwd(){ return authorPwd; }
    public void setAuthorPwd(String authorPwd){ this.authorPwd = authorPwd; }
}
