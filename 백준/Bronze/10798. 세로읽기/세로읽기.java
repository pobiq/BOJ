import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    String[] texts = new String[5];
    int maxIndex = 0;

    for (int i = 0; i < 5; i++) {
      String temp = br.readLine();
      maxIndex = Math.max(maxIndex, temp.length());
      texts[i] = temp;
    }

    for(int a = 0; a < maxIndex; a++) {
      String text1 = texts[0];
      String text2 = texts[1];
      String text3 = texts[2];
      String text4 = texts[3];
      String text5 = texts[4];
      if(text1.length() > a) {
        sb.append(text1.charAt(a));
      }

      if(text2.length() > a) {
        sb.append(text2.charAt(a));
      }

      if(text3.length() > a) {
        sb.append(text3.charAt(a));
      }

      if(text4.length() > a) {
        sb.append(text4.charAt(a));
      }

      if(text5.length() > a) {
        sb.append(text5.charAt(a));
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}