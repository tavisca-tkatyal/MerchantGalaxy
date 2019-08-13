package com.tavisca;

public class CreditStatement {
    public static String[] separateTheCreditStatementIntoWords(String s) {
        String[] answer = new String[4];
        String[] splits = s.split(" is ");
        String[] individualWord = splits[0].split(" ");
        String[] value = splits[1].split(" Credits");
        for(int i=0;i<3;i++)
        {
            answer[i]=individualWord[i];
        }
        answer[3]=value[0].trim();
        return answer;
    }
}
