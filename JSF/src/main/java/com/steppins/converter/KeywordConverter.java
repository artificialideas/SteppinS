package com.steppins.converter;

import com.steppins.controller.PostController;
import com.steppins.objects.Keyword;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "keywordConver",managed = true)
public class KeywordConverter implements Converter {
    @Inject
    private PostController postController;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0){
            for (Keyword keyword : postController.getKeywordList()) {
                if(keyword.getKeywordId() == Long.parseLong(value)){
                    return keyword;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Keyword keyword = (Keyword)object;
        return String.valueOf(keyword.getKeywordId());
    }
}
