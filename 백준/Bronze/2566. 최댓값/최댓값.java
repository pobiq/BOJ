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

    int[][] board = new int[9][9];
    int maxNumber = 0;
    int maxI = 1;
    int maxJ = 1;

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int number = Integer.parseInt(st.nextToken());
        if(maxNumber < number) {
          maxNumber = number;
          maxI = i + 1;
          maxJ = j + 1;
        }
        board[i][j] = number;
      }
    }

    sb.append(maxNumber).append("\n");
    sb.append(maxI + " " + maxJ);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}