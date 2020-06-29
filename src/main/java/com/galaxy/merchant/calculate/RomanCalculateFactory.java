package com.galaxy.merchant.calculate;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public enum RomanCalculateFactory {
    INSTANCE;

    public RomanCalculate geRomanCalculate() {
        return new RomanCalculateImpl();
    }
}
