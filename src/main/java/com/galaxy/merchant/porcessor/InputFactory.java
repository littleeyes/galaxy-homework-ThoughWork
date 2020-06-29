package com.galaxy.merchant.porcessor;


import java.util.Map;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class InputFactory {
    InputProcessor inputProcessor;

    public InputFactory(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    public void store(String inputLine) {
        inputProcessor.store(inputLine);
    }
}
