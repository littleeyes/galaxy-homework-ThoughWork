package com.galaxy.merchant.porcessor;

import com.galaxy.merchant.calculate.RomanCalculateFactory;

import static com.galaxy.merchant.MerchantConstants.*;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class RomanValueOutputProcessor implements OutputProcessor {

    @Override
    public String processOutput(String input) {
        String output = DEF_OUTPUT;
        String expression = input.substring(HOW_MUCH_IS.length(), input.length() - 1).trim();

        String[] parts = expression.split(SPLIT_SYMBOL);
        String romanNumber = evaluateRomanNumber(parts);
        Integer romanValue;
        try {
            romanValue = RomanCalculateFactory.INSTANCE.geRomanCalculate().calculate(romanNumber);
        } catch (Exception e) {
            //TODO
            return output;
        }
        output = String.format("%s is %d", expression, romanValue);
        return output;
    }

}
