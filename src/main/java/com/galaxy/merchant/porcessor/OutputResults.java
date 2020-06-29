package com.galaxy.merchant.porcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class OutputResults {
    private static List<String> outputList = new ArrayList<String>();

    public void addOutput(String output) {
        outputList.add(output);
    }

    public void clearOutput() {
        outputList.clear();
    }

    public String[] toConvertOutput() {
        return outputList.toArray(new String[0]);
    }
}
