package com.steppins.converter;

import com.steppins.controller.PostController;
import com.steppins.objects.Author;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "authorConver",managed = true)
public class AuthorConverter implements Converter {
    @Inject
    private PostController postController;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0){
            for (Author author : postController.getAuthorList()) {
                if(author.getAuthorId() == Long.parseLong(value)){
                    return author;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Author author = (Author)object;
        return String.valueOf(author.getAuthorId());
    }
}
