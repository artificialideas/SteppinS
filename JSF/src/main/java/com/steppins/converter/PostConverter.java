package com.steppins.converter;

import com.steppins.controller.PostController;
import com.steppins.objects.Post;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "postConver",managed = true)
public class PostConverter implements Converter {
    @Inject
    private PostController postController;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0){
            for (Post post : postController.getPostList()) {
                if(post.getPostId() == Long.parseLong(value)){
                    return post;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Post post = (Post)object;
        return String.valueOf(post.getPostId());
    }
}
