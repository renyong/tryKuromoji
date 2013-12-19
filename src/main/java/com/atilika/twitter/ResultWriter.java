package com.atilika.twitter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by yong on 12/17/13.
 */
class ResultWriter {
    String resultFile = "";
    BufferedWriter bw = null;


    ResultWriter(String f) {
        this.resultFile = f;
    }

    public void saveResult(String toS) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile, true), "UTF-8"));
        bw.write(toS);
        bw.newLine();
        bw.close();

    }
}
