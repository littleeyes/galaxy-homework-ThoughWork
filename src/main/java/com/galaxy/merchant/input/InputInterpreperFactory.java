package com.galaxy.merchant.input;

import com.galaxy.merchant.Interpreter;
import com.galaxy.merchant.InterpreterFactory;

public class InputInterpreperFactory implements InterpreterFactory {

    public Interpreter getInterpreter() {
        return InputInterpreterImpl.getInstance();
    }
}
