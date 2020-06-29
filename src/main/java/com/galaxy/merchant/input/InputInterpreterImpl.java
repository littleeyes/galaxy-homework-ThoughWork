package com.galaxy.merchant.input;

import com.galaxy.merchant.Interpreter;
import com.galaxy.merchant.porcessor.ProcessorFactorty;

import java.util.Arrays;

public enum InputInterpreterImpl implements Interpreter {
    INSTANCE {
        @Override
        public void parse(String[] inputs) {
            ProcessorFactorty processorFactorty = new ProcessorFactorty();
            Arrays.stream(inputs).forEach(input -> processorFactorty.inputProcessor(input.trim()));
        }
    };

    public static Interpreter getInstance() {
        return InputInterpreterImpl.INSTANCE;
    }
}
