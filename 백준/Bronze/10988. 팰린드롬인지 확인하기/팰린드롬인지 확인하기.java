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

    String str = br.readLine();
    String reverseStr = sb.append(str).reverse().toString();
    sb.delete(0, sb.length());

    if(str.equals(reverseStr)) {
      sb.append(1);
    } else {
      sb.append(0);
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}