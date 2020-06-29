package com.galaxy.merchant.output;

import com.galaxy.merchant.Interpreter;
import com.galaxy.merchant.porcessor.ProcessorFactorty;

import java.util.Arrays;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public enum OutputInterpreterImpl implements Interpreter {
    INSTANCE {
        @Override
        public void parse(String[] inputs) {
            ProcessorFactorty processorFactorty = new ProcessorFactorty();
            Arrays.stream(inputs).forEach(input -> processorFactorty.outputProcessor(input.trim()));
        }
    };

    public static Interpreter getInstance() {
        return OutputInterpreterImpl.INSTANCE;
    }
}
