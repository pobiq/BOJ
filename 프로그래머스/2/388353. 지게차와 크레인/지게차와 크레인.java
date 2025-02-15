import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  static int n, m;
  static char[][] map;

  static Queue<Node> queue = new LinkedList<>();

  static boolean[][] isAccess;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return this.x + " " + this.y;
    }
  }

  static int answer = 0;


  public int solution(String[] storage, String[] requests) {

    n = storage.length;
    m = storage[0].length();

    isAccess = new boolean[n][m];

    for(int i = 0; i < n; i++) {
      isAccess[i][0] = true;
      isAccess[i][m-1] = true;
    }

    for(int j = 0; j < m; j++) {
      isAccess[0][j] = true;
      isAccess[n-1][j] = true;
    }

    map = new char[n][m];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        map[i][j] = storage[i].charAt(j);
      }
    }

    answer = n * m;

    for(String request : requests) {
      int length = request.length();
      char text = request.charAt(0);
      for(int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if(text == map[i][j]) {
            branch(i, j, length);
          }
        }
      }

      while(!queue.isEmpty()) {
        Node node = queue.poll();
        map[node.x][node.y] = '-';
        answer -= 1;

        Queue<Node> queue1 = new LinkedList<>();
        queue1.add(new Node(node.x, node.y));

        while(!queue1.isEmpty()) {
          Node node1 = queue1.poll();
          for(int a = 0; a < 4; a++) {
            int nextX = node1.x + dx[a];
            int nextY = node1.y + dy[a];

            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

            if(map[nextX][nextY] == '-' && !isAccess[nextX][nextY]) {
              queue1.add(new Node(nextX, nextY));
            }

            isAccess[nextX][nextY] = true;
          }
        }

      }

    }

    return answer;
  }

  private void branch(int i, int j, int length) {
    if(length == 1) {
      forkLift(i, j);
    } else {
      crane(i, j);
    }
  }

  private void forkLift(int i, int j) {
    if(isAccess[i][j]) {
      process(i, j);
    }
  }

  private void process(int i, int j) {
    queue.add(new Node(i, j));
  }

  private void crane(int i, int j) {
    if(isAccess[i][j]) {
      process(i, j);
    } else {
      map[i][j] = '-';
      answer -= 1;
    }
  }

}