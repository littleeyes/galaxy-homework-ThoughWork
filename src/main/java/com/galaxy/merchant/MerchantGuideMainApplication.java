package com.galaxy.merchant;

import com.galaxy.merchant.input.InputInterpreperFactory;
import com.galaxy.merchant.output.OutputInterpreperFactory;
import com.galaxy.merchant.porcessor.OutputResults;
import com.galaxy.merchant.porcessor.QueryProcessor;

import java.util.List;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class MerchantGuideMainApplication {

    private Interpreter inputInterpreter;
    private QueryProcessor queryProcessor;
    private Interpreter outputInterpreter;
    private OutputResults outputResults;

    MerchantGuideMainApplication() {
        inputInterpreter = new InputInterpreperFactory().getInterpreter();
        outputInterpreter = new OutputInterpreperFactory().getInterpreter();
        queryProcessor = new QueryProcessor();
        outputResults = new OutputResults();
    }

    public String[] processInputs(String[] inputs) {
        inputInterpreter.parse(inputs);
        List<String> queryList = queryProcessor.getQueryList();
        String[] queries = queryList.toArray(new String[0]);
        outputInterpreter.parse(queries);
        return outputResults.toConvertOutput();
    }
}
