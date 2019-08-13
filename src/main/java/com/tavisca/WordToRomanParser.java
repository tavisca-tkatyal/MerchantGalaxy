package com.tavisca;

public class WordToRomanParser {
    public String[] parse(String input)
    {
        String[] splits =  input.split(" ");
        return new String[]{splits[0] , splits[2]} ;
    }
}
