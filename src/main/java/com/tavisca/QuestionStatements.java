package com.tavisca;

public class QuestionStatements {
    public String[] parsingQuestionStatements(String s)
    {
        String[] splits = {"", ""};
        if (s.contains("much")) {
            splits[0] = "much";
            splits[1] = s.split("how much is ")[1].split(" \\?")[0];
        } else {
            if (s.contains("many")) {
                splits[0] = "many";
                splits[1] = s.split("how many Credits is ")[1].split(" \\?")[0];
            }
        }
        return splits;
    }

    public String returnTheAnswerOfManyAndMuchStatements(String statementUsingManyAndMuch) {
        Dictionary dictionary = new Dictionary();
        RomanToNumeral romanToNumeral = new RomanToNumeral();
        String[] arrayOfInitialStatementWithManyAndMuch = parsingQuestionStatements(statementUsingManyAndMuch);
        /*if(!arrayOfInitialStatementWithManyAndMuch[0].equals("much") && !arrayOfInitialStatementWithManyAndMuch[0].equals("many"))
        {
            return "I have no idea what you are talking about";
        }*/
        String romanNumeral = "";
        if(arrayOfInitialStatementWithManyAndMuch[0].equals("much"))
        {
            String[] wordsInMuchStatementIs = arrayOfInitialStatementWithManyAndMuch[1].split(" ");
            for(String word : wordsInMuchStatementIs)
            {
                romanNumeral = romanNumeral + dictionary.map.get(word);
            }
            float valueOfWordsInDecimal = romanToNumeral.convertToDecimal(romanNumeral);

            if(Math.round(valueOfWordsInDecimal) == valueOfWordsInDecimal)
                romanNumeral = arrayOfInitialStatementWithManyAndMuch[1] + " is "+(int)valueOfWordsInDecimal;
            else
                romanNumeral = arrayOfInitialStatementWithManyAndMuch[1] + " is "+valueOfWordsInDecimal;
        }
        else if(arrayOfInitialStatementWithManyAndMuch[0].equals("many"))
        {
            String[] extractIndividualWordsFromStatement = arrayOfInitialStatementWithManyAndMuch[1].split(" ");
            for(int i=0;i<2;i++)
            {
                String word = extractIndividualWordsFromStatement[i];
                romanNumeral = romanNumeral + Dictionary.map.get(word);
            }
            float valueOfWordInDecimal = romanToNumeral.convertToDecimal(romanNumeral);

            String itemIs = extractIndividualWordsFromStatement[2];
            float valueOfItemIs = ValuePerItem.mappingOfValueWithItem.get(itemIs);

            float resultOfThisStatementIs = (valueOfItemIs * valueOfWordInDecimal);
            if(Math.round(resultOfThisStatementIs) == resultOfThisStatementIs)
                romanNumeral = arrayOfInitialStatementWithManyAndMuch[1] + " is "+(int)resultOfThisStatementIs +" Credits";
            else
                romanNumeral = arrayOfInitialStatementWithManyAndMuch[1] + " is "+resultOfThisStatementIs+" Credits";
        }

        return romanNumeral;
    }
}