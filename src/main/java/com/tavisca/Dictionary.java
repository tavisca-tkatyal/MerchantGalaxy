package com.tavisca;

import java.util.HashMap;

public class Dictionary {
    public static HashMap<String, String> map = new HashMap<>();

    public static String[] CalculateTheCredit(String input) {
        // ValuePerItem valuePerItem = new ValuePerItem();
        String[] splits = CreditStatement.separateTheCreditStatementIntoWords(input);
        String RomanNumeral = map.get(splits[0]) + map.get(splits[1]);
        String nameOfItem = splits[2];
        float integerValueOfRomanNumeral = (float) RomanToNumeral.convertToDecimal(RomanNumeral);

        float valueOfItemIsFetchFromStatement = Float.parseFloat(splits[3]);

        float actualValueIs = valueOfItemIsFetchFromStatement / integerValueOfRomanNumeral;

        if (Math.round(actualValueIs) == actualValueIs)
            return new String[]{splits[2], String.valueOf(Math.round(actualValueIs))};

        return new String[]{splits[2], String.valueOf(actualValueIs)};

        // ValuePerItem.mappingOfValueWithItem.put(nameOfItem,actualValueIs);
    }
}