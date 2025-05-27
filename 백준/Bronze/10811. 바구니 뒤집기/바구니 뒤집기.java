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

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] basket = new int[n];

    for (int i = 0; i < n; i++) {
      basket[i] = i + 1;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      int mid = (b - a) / 2;

      for (int j = 0; j <= mid; j++) {
        int tmp = basket[b-j];
        basket[b-j] = basket[a+j];
        basket[a+j] = tmp;
      }
    }

    for (int i = 0; i < n; i++) {
      sb.append(basket[i] + " ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}