package com.ww.tooling;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by luisrueda on 1/30/19.
 */
public class NameRandomizer {
    public  String generateRandomName(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        return RandomStringUtils.random(length, allowedChars);
    }
}