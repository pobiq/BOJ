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

    String s = br.readLine();
    int i = Integer.parseInt(br.readLine());
    char c = s.charAt(i-1);

    sb.append(c);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}