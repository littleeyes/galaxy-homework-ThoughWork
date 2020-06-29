package com.galaxy.merchant.porcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.galaxy.merchant.MerchantConstants.QUERY_SYMBOL;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public class QueryProcessor implements InputProcessor {
    private static List<String> queryList = new ArrayList<String>();

    @Override
    public void store(String inputLine) {
        if (inputLine.endsWith(QUERY_SYMBOL)) {
            queryList.add(inputLine);
        }
    }

    @Override
    public Map getStorageMap() {
        return null;
    }

    public List<String> getQueryList() {
        return queryList;
    }

    public void clearQueryList() {
        queryList.clear();
    }
}
