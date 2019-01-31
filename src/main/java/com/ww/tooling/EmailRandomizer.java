package com.ww.tooling;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by luisrueda on 1/30/19.
 */
public class EmailRandomizer {
    public  String generateRandomEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp + "@testdata.com";
        return email;
    }
}
