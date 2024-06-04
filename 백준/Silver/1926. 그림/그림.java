import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n,m;
  static int[][] map;
  static boolean[][] visited;

  static int[] dx = {-1, 1, 0, 0};

  static int[] dy = {0, 0, -1, 1};

  public static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int photoCount = 0;
  static int maxArea = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st1.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(map[i][j] == 1 && !visited[i][j]) {
          bfs(i, j);
        }
      }
    }

    sb.append(photoCount).append("\n");
    sb.append(maxArea);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  public static void bfs(int a, int b) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(a, b));
    int area = 0;
    visited[a][b] = true;
    photoCount++;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      int x = node.x;
      int y = node.y;
      area++;

      for(int i = 0; i < 4; i++) {
        int nextX = x + dx[i];
        int nextY = y + dy[i];

        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

        if(visited[nextX][nextY]) continue;

        if(map[nextX][nextY] == 0) continue;

        visited[nextX][nextY] = true;
        queue.add(new Node(nextX, nextY));

      }

    }

    maxArea = Math.max(maxArea, area);

  }



}