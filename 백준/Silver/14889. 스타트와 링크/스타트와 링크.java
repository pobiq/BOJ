import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int n = 0;
  static int[][] array;
  static int diffMin = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    n = Integer.parseInt(br.readLine());

    array = new int[n][n];

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] startArray = new int[n/2];

    dfs(startArray, 0, 0, n/2);

    sb.append(diffMin);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void dfs(int[] startArray, int start, int depth, int k) {
    if(depth == k) {
      calculation(startArray);
      return;
    }

    for(int i = start; i < n; i++) {
      startArray[depth] = i;
      dfs(startArray, i+1, depth+1, k);
    }

  }

  private static void calculation(int[] startArray) {
    int[] countArray = new int[n];
    int startScore = 0;
    int linkScore = 0;

    for(int number : startArray) {
      countArray[number]++;
    }

    for(int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if(countArray[i] == 1 && countArray[j] == 1) {
          startScore += array[i][j];
          startScore += array[j][i];
        } else if(countArray[i] == 0 && countArray[j] == 0) {
          linkScore += array[i][j];
          linkScore += array[j][i];
        }
      }
    }

    int diff = Math.abs(startScore - linkScore);
    diffMin = Math.min(diff, diffMin);

  }

}