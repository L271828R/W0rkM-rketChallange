package com.ww.tooling;

import java.util.HashMap;
import java.util.Iterator;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;

public class JSONToMap
{

    private HashMap<String, String> map = new HashMap<String, String>();

     JSONToMap(String t) throws JSONException {


        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key);
            map.put(key, value);

        }

        System.out.println("json : "+jObject);
        System.out.println("map : "+map);
    }

    public HashMap<String, String> getMap() {
        return map;
    }
}