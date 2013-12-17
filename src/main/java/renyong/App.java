package renyong;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Iterator;

/**
 * 2013.12.16
 * Try to use Kuromoji to process Japanese Tweets
 */

class TweetsReader
{
    String fileName = "tweets";
    BufferedReader br = null;
    String fileCnt = "";

    public String readTweets(){
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                fileCnt += line;
                fileCnt += "\n";
            }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Something wrong when reading file");
        }finally {
            try{
                br.close();
            }catch (Exception e){
                System.out.println("Something wrong when closing file");
            }
        }
        return fileCnt;
    }
}

public class App
{
    public static void main( String[] args ){
        System.out.println( "This is the 1st project!" );
        String twCnt = "";
        Tokenizer tokenizer = Tokenizer.builder().build();
        TweetsReader twr = new TweetsReader();
        twCnt = twr.readTweets();
        //System.out.println(twCnt);
        String []texts = twCnt.split("\n");
        for(String text : texts){
            System.out.println("Before processed");
            System.out.println(text);
            System.out.println("After processed");
            for(Token token : tokenizer.tokenize(text)){
                System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
            }

        }
        //for (Token token : tokenizer.tokenize("こういう新たな気づきを与えるものこそがデータマイニングですよねえ（真顔） " +
        //        "QT ハッカソンに参加してきました：そして優勝してきた 。wwwwwww")) {
        //    System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
        //}
    }


}
