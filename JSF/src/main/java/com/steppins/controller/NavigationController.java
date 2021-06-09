package com.steppins.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class NavigationController implements Serializable {
    @ManagedProperty(value = "#{param.postUrl}")
    private String postUrl;
    private String authorUrl;
    private String keywordUrl;

    //Author URL
    public String getAuthorParam(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("authorUrl");
    }
    public String authorPage(){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.authorUrl = getAuthorParam(fc);
        return "searchResults";
    }
    //Keyword URL
    public String getKeywordParam(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("keywordUrl");
    }
    public String keywordPage(){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.keywordUrl = getKeywordParam(fc);
        return "searchResults";
    }

    public String getPostUrl(){ return postUrl; }
    public void setPostUrl(String postUrl){ this.postUrl = postUrl; }
    public String getAuthorUrl(){ return authorUrl; }
    public void setAuthorUrl(String authorUrl){ this.authorUrl = authorUrl; }
    public String getKeywordUrl(){ return keywordUrl; }
    public void setKeywordUrl(String keywordUrl){ this.keywordUrl = keywordUrl; }
}
