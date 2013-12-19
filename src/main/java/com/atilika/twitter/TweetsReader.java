package com.atilika.twitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2013.12.16
 * Try to use Kuromoji to process Japanese Tweets
 */

class TweetsReader {

    String fileName = "";
    BufferedReader br = null;
    String fileCnt = "";

    TweetsReader(String f){
        this.fileName = f;
    }

    public String readTweets() {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                fileCnt += line;
                fileCnt += "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong when reading file");
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Something wrong when closing file");
            }
        }
        return fileCnt;
    }
}
