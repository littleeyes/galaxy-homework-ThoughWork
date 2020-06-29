package com.galaxy.merchant.porcessor;

import java.util.Map;

/**
 * @author lisanchuan
 * @date 2019-03-14
 */
public interface InputProcessor {
    void store(String inputLine);

    Map getStorageMap();
}
