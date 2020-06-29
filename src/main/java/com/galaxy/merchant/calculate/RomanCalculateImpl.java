package com.galaxy.merchant.calculate;

import static com.galaxy.merchant.MerchantConstants.ROMAN_NUMBER_VALIDATOR;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class RomanCalculateImpl implements RomanCalculate {

    @Override
    public int calculate(String roman) {
        if (roman.matches(ROMAN_NUMBER_VALIDATOR)) {
            return convert(roman);
        }
        return -1;
    }

    private static int convert(String roman) {
        int decimalValue = 0;
        int lastRomanNumber = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i);
            decimalValue = compareCalculate(Roman.getValueFromRoman(ch), lastRomanNumber, decimalValue);
            lastRomanNumber = Roman.getValueFromRoman(ch);
        }

        return decimalValue;
    }

    private static int compareCalculate(int currentDecimalNumber, int lastRomanNumber, int lastDecimalValue) {
        if (lastRomanNumber > currentDecimalNumber) {
            return lastDecimalValue - currentDecimalNumber;
        } else {
            return lastDecimalValue + currentDecimalNumber;
        }
    }
}
