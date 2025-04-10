import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int r,c = 0;
  static boolean[] visited;
  static char[][] graph;

  static int[] dx = {-1, 1, 0, 0};

  static int[] dy = {0, 0, -1, 1};

  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    visited = new boolean[26];

    graph = new char[r][c];

    for(int i = 0; i < r; i++) {
      char[] temp = br.readLine().toCharArray();
      for (int j = 0; j < c; j++) {
        graph[i][j] = temp[j];
      }
    }

    dfs(0, 0, 1);

    sb.append(result);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void dfs(int x, int y, int count) {
    // 현재 위치 처리
    int index = graph[x][y] - 'A';

    if (visited[index]) return;

    visited[index] = true;
    result = Math.max(result, count);

    // 네 방향으로 이동
    for (int i = 0; i < 4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      // 범위를 벗어나지 않는지 확인
      if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
        dfs(nextX, nextY, count + 1);
      }
    }

    // 백트래킹: 원래 상태로 복구
    visited[index] = false;

  }

}