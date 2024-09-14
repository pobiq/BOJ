import java.util.*;

class Solution {
  static int[] dx;
  static int[] dy;

  static boolean[][] vistied;

  static int row;
  static int col;

  static int numberOfArea;
  static int maxSizeOfOneArea;

  public class Node {
    int x;
    int y;
    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int[] solution(int m, int n, int[][] picture) {
    int[] answer = new int[2];

    numberOfArea = 0;
    maxSizeOfOneArea = 0;

    row = picture.length;
    col = picture[0].length;

    dx = new int[]{-1, 1, 0, 0};
    dy = new int[]{0, 0, -1, 1};

    vistied = new boolean[row][col];

    for(int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if(!vistied[i][j] && picture[i][j] != 0) {
          bfs(i, j, picture);
        }
      }
    }

    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;

    return answer;
  }

  public void bfs(int a, int b, int[][] picture) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(a, b));
    vistied[a][b] = true;
    numberOfArea++;

    int areaSize = 0;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      areaSize++;

      for(int i = 0; i < 4; i++) {
        int nextX = node.x + dx[i];
        int nextY = node.y + dy[i];

        if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;

        if(picture[nextX][nextY] == 0) continue;

        if(picture[nextX][nextY] != picture[a][b]) continue;

        if(vistied[nextX][nextY]) continue;

        vistied[nextX][nextY] = true;
        queue.add(new Node(nextX, nextY));
      }
    }

    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
  }
}