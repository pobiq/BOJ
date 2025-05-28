import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        int number = Integer.parseInt(st.nextToken());
        pq.add(number);
      }
    }

    for(int i = 0; i < n - 1; i++) {
      pq.poll();
    }
    
    sb.append(pq.poll());

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}