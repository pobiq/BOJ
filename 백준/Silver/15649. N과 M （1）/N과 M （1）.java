import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] input = IntStream.rangeClosed(1, n).toArray();
    int[] output = new int[m];
    boolean[] visited = new boolean[n];

    permutation(input, output, visited, 0, m);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void permutation(int[] input, int[] output,
      boolean[] visited, int depth, int m) {
    if(depth == m) {

      for(int number : output) {
        System.out.print(number + " ");
      }
      System.out.println();

      return;
    }

    for(int i = 0; i < input.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = input[i];
        permutation(input, output, visited,depth+1, m);
        visited[i] = false;
      }
    }

  }

}