package com.galaxy.merchant.porcessor;

import java.util.HashMap;
import java.util.Map;

import static com.galaxy.merchant.MerchantConstants.SPLIT_SYMBOL;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class NumberProcessor implements InputProcessor {
    private static HashMap<String, String> numberMap = new HashMap<>();

    @Override
    public void store(String inputLine) {
        String[] parts = inputLine.split(SPLIT_SYMBOL);
        numberMap.put(parts[0], parts[2].replaceAll("\r", ""));
    }

    @Override
    public Map getStorageMap() {
        return numberMap;
    }
}
