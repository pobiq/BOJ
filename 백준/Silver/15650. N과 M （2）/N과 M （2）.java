import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    combination(input, output, 0, 0, m);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void combination(int[] input, int[] output, int depth, int start, int m) {
    if(depth == m) {
      for(int number : output) {
        System.out.print(number + " ");
      }
      System.out.println();
      return;
    }

    for(int i = start; i < input.length; i++) {
      output[depth] = input[i];
      combination(input, output, depth+1, i+1, m);
    }

  }

}