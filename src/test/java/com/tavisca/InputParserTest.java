package com.tavisca;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputParserTest {

    private static Dictionary dictionary;

    @BeforeAll
    void createInstance()  {
        dictionary = new Dictionary();
        WordToRomanParser wordToRomanParse = new WordToRomanParser();
        dictionary.map.put(wordToRomanParse.parse("glob is I")[0],wordToRomanParse.parse("glob is I")[1]);
        dictionary.map.put(wordToRomanParse.parse("prok is V")[0],wordToRomanParse.parse("prok is V")[1]);
        dictionary.map.put(wordToRomanParse.parse("pish is X")[0],wordToRomanParse.parse("pish is X")[1]);
        dictionary.map.put(wordToRomanParse.parse("tegj is L")[0],wordToRomanParse.parse("tegj is L")[1]);
    }

    @Test
    void canParseWordToRomanNumeral()
    {
        WordToRomanParser wordToRomanParse = new WordToRomanParser();
        String[] expectedResult = new String[] {"glob","I"};
        assertArrayEquals(expectedResult, wordToRomanParse.parse("glob is I"));

        expectedResult = new String[]{"prok","V"};
        assertArrayEquals(expectedResult, wordToRomanParse.parse("prok is V"));

        expectedResult = new String[]{"pish","X"};
        assertArrayEquals(expectedResult, wordToRomanParse.parse("pish is X"));

        expectedResult = new String[]{"tegj", "L"};
        assertArrayEquals(expectedResult, wordToRomanParse.parse("tegj is L"));
    }

    @Test
    void canParseWordsToManyAndMuchStatement()
    {
        QuestionStatements questionStatements = new QuestionStatements();
        assertArrayEquals(new String[]{"much","pish tegj glob glob"}, questionStatements.parsingQuestionStatements("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"many","glob prok Gold"}, questionStatements.parsingQuestionStatements("how many Credits is glob prok Gold ?"));
    }

}