package com.ww.tooling;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;


public class ConfigReader {

    private HashMap config;

    public ConfigReader (String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = ConfigReader.class.getResourceAsStream(path);
        String jsonTxt = IOUtils.toString( is );
        JSONToMap jsonToMap = new JSONToMap(jsonTxt);
        config = jsonToMap.getMap();
    }

    public HashMap getConfig() {
        return config;
    }

}
