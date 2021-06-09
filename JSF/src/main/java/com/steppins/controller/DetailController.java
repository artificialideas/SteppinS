package com.steppins.controller;

import com.steppins.DAO.DAOFactory;
import com.steppins.objects.Post;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

@Named
@SessionScoped
public class DetailController implements Serializable {
    /* Full post */
    private Long postId;
    private Long postAuthorId;
    private String postTitle;
    private Date postDate;
    private String postCode;
    private String postDescription;
    private String postOutput;
    private String postSource;
    private Post currentPost;

    @Inject
    NavigationController navigationController;

    public String loadPost(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        postId = Long.parseLong(params.get("postUrl"));

        currentPost = DAOFactory.postDAO().read(postId);
        if(currentPost != null) {
            postTitle = currentPost.getPostTitle();
            postDate = (Date) currentPost.getPostDate();
            postCode = currentPost.getPostCode();
            postDescription = currentPost.getPostDescription();
            postOutput = currentPost.getPostOutput();
            postSource = currentPost.getPostSource();
        }
        return "post";
    }

    public Long getPostId(){ return postId; }
    public void setPostId(Long postId){ this.postId = postId; }
    public Long getPostAuthorId(){ return postAuthorId; }
    public void setPostAuthorId(Long postAuthorId){ this.postAuthorId = postAuthorId; }
    public String getPostTitle(){ return postTitle; }
    public void setPostTitle(String postTitle){ this.postTitle = postTitle; }
    public Date getPostDate(){ return postDate; }
    public void setPostDate(Date postDate){ this.postDate = postDate; }
    public String getPostCode(){ return postCode; }
    public void setPostCode(String postCode){ this.postCode = postCode; }
    public String getPostDescription(){ return postDescription; }
    public void setPostDescription(String postDescription){ this.postDescription = postDescription; }
    public String getPostOutput(){ return postOutput; }
    public void setPostOutput(String postOutput){ this.postOutput = postOutput; }
    public String getPostSource(){ return postSource; }
    public void setPostSource(String postSource){ this.postSource = postSource; }
}
