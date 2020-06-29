package com.galaxy.merchant.output;

import com.galaxy.merchant.Interpreter;
import com.galaxy.merchant.InterpreterFactory;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class OutputInterpreperFactory implements InterpreterFactory {

    @Override
    public Interpreter getInterpreter() {
        return OutputInterpreterImpl.getInstance();
    }
}
