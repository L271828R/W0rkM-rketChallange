package com.ww.tooling;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by luisrueda on 1/30/19.
 */
public class PasswordRandomizer {
    public  String generateRandomPassword(int numberOfAlpha, int numberOfDigits) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        String allowedDigits = "0123456789";
        String alpha =  RandomStringUtils.random(numberOfAlpha, allowedChars);
        String digits = RandomStringUtils.random(numberOfDigits, allowedDigits);
        String result = alpha + digits;
        System.out.println(result);
        return result;
    }
}