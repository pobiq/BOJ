import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    int[][] paper = new int[100][100];

    int n = Integer.parseInt(br.readLine());
    int count = 0;

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      for (int j = a; j < a+10; j++) {
        for (int k = b; k < b+10; k++) {
          paper[j][k] = 1;
        }
      }
    }

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if(paper[i][j] == 1) {
          count++;
        }
      }
    }

    sb.append(count);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}