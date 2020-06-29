package com.galaxy.merchant.porcessor;

import com.galaxy.merchant.calculate.Roman;
import com.galaxy.merchant.calculate.RomanCalculateFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.galaxy.merchant.MerchantConstants.*;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class CreditsProcessor implements InputProcessor {
    private static HashMap<String, Double> creditsMap = new HashMap<>();

    @Override
    public void store(String inputLine) {
        String creditStr = inputLine.substring(0, inputLine.indexOf(CREDITS_SYMBOL));
        String[] parts = creditStr.split(CREDITS_EQUAL_SYMBOL);
        Double creditValue;
        try {
            creditValue = Double.parseDouble(parts[1].trim());
        } catch (NumberFormatException e) {
            //TODO
            return;
        }

        String[] creditItems = parts[0].trim().split(SPLIT_SYMBOL);
        String coin = creditItems[creditItems.length - 1];
        //TODO

        InputProcessor inputProcessor = new NumberProcessor();
        StringBuffer romanNumber = new StringBuffer();
        Arrays.stream(creditItems)
                .filter(item -> inputProcessor.getStorageMap().containsKey(item))
                .forEach(item -> {
                    if (inputProcessor.getStorageMap().containsKey(item)) {
                        String roman = inputProcessor.getStorageMap().get(item).toString();
                        romanNumber.append(Roman.tryParse(roman));
                    } else {
                        //TODO
                    }
                });

        try {
            creditValue = creditValue / RomanCalculateFactory.INSTANCE.geRomanCalculate().calculate(romanNumber.toString());
        } catch (Exception e) {
            return;
        }
        creditsMap.put(coin, creditValue);
    }

    @Override
    public Map getStorageMap() {
        return creditsMap;
    }
}
