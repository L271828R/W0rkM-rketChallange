package com.ww.tooling;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/***************************************************************************************
 *    Code partially borrowed/inspired from the below
 *    Title: How To Find Broken Links Using Selenium WebDriver
 *    URL: https://www.softwaretestingmaterial.com/broken-links-using-selenium/
 ***************************************************************************************/

public class URLvalidator {
    public static Boolean isLinkBroken(String urlLink) {

        Boolean result = new Boolean(true);

        try{
            URL link = new URL(urlLink);
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            if(httpConn.getResponseCode()== 200) {
                result = false;
            }
            if(httpConn.getResponseCode()== 404) {
                result =  true;
            }
            return result;
        }
        catch (IOException e) {
            return true;
        }
    }
}

