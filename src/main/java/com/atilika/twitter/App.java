package com.atilika.twitter;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

import java.io.*;

public class App {
    public static void saveProcessed(String processedSt){
        ResultWriter rwt = new ResultWriter();
        try {
            rwt.saveResult(processedSt);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something is wrong when saving the result");
        }

    }
    public static void main(String[] args) {
        System.out.println("This is the 1st project!");
        String twCnt = "";
        Tokenizer tokenizer = Tokenizer.builder().build();
        TweetsReader twr = new TweetsReader();
        twCnt = twr.readTweets();
        //System.out.println(twCnt);
        String[] texts = twCnt.split("\n");
        for (String text : texts) {
            System.out.println("Before processed");
            System.out.println(text);
            System.out.println("After processed");
            for (Token token : tokenizer.tokenize(text)) {
                String tmpSt = token.getSurfaceForm() + "\t" + token.getAllFeatures();
                System.out.println(tmpSt);
                saveProcessed(tmpSt);
            }

        }
        //for (Token token : tokenizer.tokenize("こういう新たな気づきを与えるものこそがデータマイニングですよねえ（真顔） " +
        //        "QT ハッカソンに参加してきました：そして優勝してきた 。wwwwwww")) {
        //    System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
        //}
    }


}
