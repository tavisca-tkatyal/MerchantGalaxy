package com.tavisca;

public class WordToRomanParser {
    public static void main(String[] args) {
        System.out.println("hello !");
    }
    public String[] parse(String input)
    {
        String[] splits =  input.split(" ");
        return new String[]{splits[0] , splits[2]} ;
    }
}
