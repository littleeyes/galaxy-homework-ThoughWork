package com.galaxy.merchant.porcessor;


import com.galaxy.merchant.calculate.RomanCalculateFactory;

import static com.galaxy.merchant.MerchantConstants.DEF_OUTPUT;
import static com.galaxy.merchant.MerchantConstants.HOW_MANY_CREDITS_IS;
import static com.galaxy.merchant.MerchantConstants.SPLIT_SYMBOL;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class CreditValueOutputProcessor implements OutputProcessor {

    @Override
    public String processOutput(String input) {
        String output;
        String expression = input.substring(HOW_MANY_CREDITS_IS.length(), input.length() - 1).trim();

        String[] parts = expression.split(SPLIT_SYMBOL);

        String creditCoinValue = parts[parts.length - 1];
        double coinValue = 0;

        InputProcessor inputProcessor = new CreditsProcessor();

        if (inputProcessor.getStorageMap().containsKey(creditCoinValue)) {
            coinValue = (Double) inputProcessor.getStorageMap().get(creditCoinValue);
        } else {
            return DEF_OUTPUT;
            //TODO
        }
        if (coinValue == 0) {
            //TODO
        }

        String expressionPart = expression.substring(0, expression.indexOf(creditCoinValue)).trim();
        parts = expressionPart.split(SPLIT_SYMBOL);

        String romanNumber = evaluateRomanNumber(parts);
        int value = 0;
        try {
            value = (int) (coinValue * RomanCalculateFactory.INSTANCE.geRomanCalculate().calculate(romanNumber));
        } catch (Exception e) {
            //TODO
        }

        output = String.format("%s is %d Credits", expression, value);
        return output;
    }
}
