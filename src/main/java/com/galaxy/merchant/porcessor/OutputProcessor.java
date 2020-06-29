package com.galaxy.merchant.porcessor;

import com.galaxy.merchant.calculate.Roman;

import java.util.Arrays;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public interface OutputProcessor {

    String processOutput(String input);

    default String evaluateRomanNumber(String[] inputs) {
        StringBuffer romanNumber = new StringBuffer();
        InputProcessor inputProcessor = new NumberProcessor();
        Arrays.stream(inputs)
                .forEach(item -> {
                    if (inputProcessor.getStorageMap().containsKey(item)){
                        String roman = inputProcessor.getStorageMap().get(item).toString();
                        //TODO
                        romanNumber.append(Roman.tryParse(roman));
                    }else{
                        //TODO
                    }

                });
        return romanNumber.toString();
    }
}
