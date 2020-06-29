package com.galaxy.merchant.porcessor;


import static com.galaxy.merchant.MerchantConstants.CREDITS_SYMBOL;
import static com.galaxy.merchant.MerchantConstants.DEF_OUTPUT;
import static com.galaxy.merchant.MerchantConstants.EQUAL_SYMBOL;
import static com.galaxy.merchant.MerchantConstants.GOODS_SPLIT_LENGTH;
import static com.galaxy.merchant.MerchantConstants.HOW_MANY_CREDITS_IS;
import static com.galaxy.merchant.MerchantConstants.HOW_MUCH_IS;
import static com.galaxy.merchant.MerchantConstants.QUERY_SYMBOL;
import static com.galaxy.merchant.MerchantConstants.SPLIT_SYMBOL;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class ProcessorFactorty {

    private InputProcessor inputProcessor;
    private OutputResults outputResults = new OutputResults();

    public void inputProcessor(String input) {
        String[] parts = input.split(SPLIT_SYMBOL);
        if (parts[1].equals(EQUAL_SYMBOL) && parts.length == GOODS_SPLIT_LENGTH) {
            inputProcessor = new NumberProcessor();
        }

        if (input.endsWith(CREDITS_SYMBOL)) {
            inputProcessor = new CreditsProcessor();
        }

        if (input.endsWith(QUERY_SYMBOL)) {
            inputProcessor = new QueryProcessor();
        }

        if (inputProcessor == null) {
            //TODO
        }

        InputFactory inputFactory = new InputFactory(inputProcessor);
        inputFactory.store(input);
    }

    public void outputProcessor(String input) {
        String output = null;
        if (input.startsWith(HOW_MUCH_IS)) {
            output = new RomanValueOutputProcessor().processOutput(input);
        }

        if (input.startsWith(HOW_MANY_CREDITS_IS)) {
            output = new CreditValueOutputProcessor().processOutput(input);
        }

        if (output == null) {
            output = DEF_OUTPUT;
        }
        outputResults.addOutput(output);
    }
}
