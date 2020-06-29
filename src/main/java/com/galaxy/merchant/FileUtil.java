package com.galaxy.merchant;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lisanchuan
 * @date 2019-03-15
 */
public class FileUtil {
    public static String loadFile(String fileName) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
        String testInput = null;
        try {
            testInput = new String(Files.readAllBytes(Paths.get(url.toURI())));
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO
            e.printStackTrace();
        }
        return testInput;
    }
}
