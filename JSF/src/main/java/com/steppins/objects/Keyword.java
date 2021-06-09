package com.steppins.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Keyword {
    private Long keywordId;
    private String keywordName;
    private String colorCode;

    public Keyword(Long keywordId, String keywordName){}
    public Keyword(Long keywordId, String keywordName, String colorCode){
        this.keywordId = keywordId;
        this.keywordName = keywordName;
        this.colorCode = colorCode;
    }

    public Long getKeywordId(){ return keywordId; }
    public void setKeywordId(Long keywordId){ this.keywordId = keywordId; }
    public String getKeywordName(){ return keywordName; }
    public void setKeywordName(String keywordName){ this.keywordName = keywordName; }
    public String getColorCode(){ return colorCode; }
    public void setColorCode(String colorCode){ this.colorCode = colorCode; }

    //When a new keyword is added, create a random color and push it to the KEYWORD table
    public static void randomColor() {
        // create object of Random class
        Random rnd_color = new Random();
        //If a number starts with 0x, it means the rest of the digits are interpreted as HEX
        int rnd_num = rnd_color.nextInt(0xffffff + 1);
        // format it as hexadecimal string and print
        String colorCode = String.format("#%06x", rnd_num);
        System.out.println(colorCode);
    }

}
