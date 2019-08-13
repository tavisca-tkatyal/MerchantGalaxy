package com.tavisca;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputCreditParserTest {
    private Dictionary dictionary;
    private ValuePerItem valuePerItem;

    @BeforeAll
    void createInstance()  {
        dictionary = new Dictionary();
        valuePerItem = new ValuePerItem();
        WordToRomanParser wordToRomanParse = new WordToRomanParser();
        dictionary.map.put(wordToRomanParse.parse("glob is I")[0],wordToRomanParse.parse("glob is I")[1]);
        dictionary.map.put(wordToRomanParse.parse("prok is V")[0],wordToRomanParse.parse("prok is V")[1]);
        dictionary.map.put(wordToRomanParse.parse("pish is X")[0],wordToRomanParse.parse("pish is X")[1]);
        dictionary.map.put(wordToRomanParse.parse("tegj is L")[0],wordToRomanParse.parse("tegj is L")[1]);
        ValuePerItem.mappingOfValueWithItem.put(dictionary.CalculateTheCredit("glob glob Silver is 34 Credits")[0],Float.parseFloat(dictionary.CalculateTheCredit("glob glob Silver is 34 Credits")[1]));
        ValuePerItem.mappingOfValueWithItem.put(dictionary.CalculateTheCredit("glob prok Gold is 57800 Credits")[0],Float.parseFloat(dictionary.CalculateTheCredit("glob prok Gold is 57800 Credits")[1]));
        ValuePerItem.mappingOfValueWithItem.put(dictionary.CalculateTheCredit("pish pish Iron is 3910 Credits")[0],Float.parseFloat(dictionary.CalculateTheCredit("pish pish Iron is 3910 Credits")[1]));

    }

    @Test
    void canParseWordsToCreditsStatement()
    {
        String[] result = new String[]{"glob", "glob","Silver","34"};

        assertArrayEquals(result,CreditStatement.separateTheCreditStatementIntoWords("glob glob Silver is 34 Credits"));

        result = new String[]{"glob", "prok", "Gold" ,"57800"};
        assertArrayEquals(result,CreditStatement.separateTheCreditStatementIntoWords("glob prok Gold is 57800 Credits"));

        result = new String[]{"pish","pish","Iron","3910"};
        assertArrayEquals(result,CreditStatement.separateTheCreditStatementIntoWords("pish pish Iron is 3910 Credits"));
    }
    @Test
    void canCalculateCreditsStatement()
    {

        valuePerItem = new ValuePerItem();
        String[] result = new String[]{"Silver","17"};

        assertArrayEquals(result,dictionary.CalculateTheCredit("glob glob Silver is 34 Credits"));

        result = new String[]{"Gold","14450"};
        assertArrayEquals(result,dictionary.CalculateTheCredit("glob prok Gold is 57800 Credits"));

        result = new String[]{"Iron","195.5"};
        assertArrayEquals(result,dictionary.CalculateTheCredit("pish pish Iron is 3910 Credits"));
    }

    @Test
    void canGiveAnswerToManyAndMuchStatements()
    {
        QuestionStatements questionStatements = new QuestionStatements();
        String actualResult = "pish tegj glob glob is 42";
        assertEquals(actualResult,questionStatements.returnTheAnswerOfManyAndMuchStatements("how much is pish tegj glob glob ?"));

        actualResult = "glob prok Silver is 68 Credits";
        assertEquals(actualResult,questionStatements.returnTheAnswerOfManyAndMuchStatements("how many Credits is glob prok Silver ?"));

        actualResult = "glob prok Gold is 57800 Credits";
        assertEquals(actualResult,questionStatements.returnTheAnswerOfManyAndMuchStatements("how many Credits is glob prok Gold ?"));

        actualResult = "glob prok Iron is 782 Credits";
        assertEquals(actualResult,questionStatements.returnTheAnswerOfManyAndMuchStatements("how many Credits is glob prok Iron ?"));
    }

}