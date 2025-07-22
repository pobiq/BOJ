import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int n = 9;
  static int[][] graph;

  static List<Node> blank = new ArrayList<>();

  static int[][] colCount = new int[9][10];
  static int[][] rowCount = new int[9][10];
  static int[][] squareCount = new int[9][10];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    graph = new int[n][n];


    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int number = Integer.parseInt(st.nextToken());

        if(number == 0) {
          blank.add(new Node(i, j));
        } else {
          rowCount[i][number] = 1;
          colCount[j][number] = 1;

          int index = (i / 3) * 3 + j / 3;
          squareCount[index][number] = 1;
        }

        graph[i][j] = number;
      }
    }

    dfs(0);

    sb.append(" ");
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void dfs(int depth) {
    if(depth == blank.size()) {
      // 결과 출력
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(graph[i][j] + " ");
        }
        System.out.println();
      }
      System.exit(0);
      return;
    }


      Node node = blank.get(depth);
      int x = node.x;
      int y = node.y;

      int index = (x / 3) * 3 + y / 3;

      for(int num = 1; num <= 9 ; num++) {
        if(rowCount[x][num] == 0 && colCount[y][num] == 0 &&
          squareCount[index][num] == 0) {

          graph[x][y] = num;
          rowCount[x][num] = 1;
          colCount[y][num] = 1;
          squareCount[index][num] = 1;

          dfs(depth + 1);

          graph[x][y] = 0;
          rowCount[x][num] = 0;
          colCount[y][num] = 0;
          squareCount[index][num] = 0;
      }
    }
  }

}