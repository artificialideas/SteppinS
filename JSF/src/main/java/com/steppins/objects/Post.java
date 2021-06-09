package com.steppins.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Long postId;
    private String postTitle;
    private Date postDate;
    private String postCode;
    private String postDescription;
    private String postOutput;
    private String postSource;
    private Long postAuthorId;

    public Post(Long postId, String postTitle){}
    public Post(Long postId, String postTitle, Long postAuthorId, Date postDate, String postCode, String postDescription, String postOutput, String postSource){
        this.postId = postId;
        this.postTitle = postTitle;
        this.postAuthorId = postAuthorId;
        this.postDate = postDate;
        this.postCode = postCode;
        this.postDescription = postDescription;
        this.postOutput = postOutput;
        this.postSource = postSource;
    }

    public Long getPostId(){ return postId; }
    public void setPostId(Long postId){ this.postId = postId; }
    public String getPostTitle(){ return postTitle; }
    public void setPostTitle(String postTitle){ this.postTitle = postTitle; }
    public Long getPostAuthorId(){ return postAuthorId; }
    public void setPostAuthorId(Long postAuthorId){ this.postAuthorId = postAuthorId; }
    public Date getPostDate(){ return postDate; }
    public void setPostDate(Date postDate){ this.postDate = postDate; }
    public String getPostCode(){ return postCode; }
    public void setPostCode(String postCode){ this.postCode = postCode; }
    public String getPostDescription(){ return postDescription; }
    public void setPostDescription(String postDescription){this.postDescription = postDescription; }
    public String getPostOutput(){ return postOutput; }
    public void setPostOutput(String postOutput){ this.postOutput = postOutput; }
    public String getPostSource(){ return postSource; }
    public void setPostSource(String postSource){ this.postSource = postSource; }
}
