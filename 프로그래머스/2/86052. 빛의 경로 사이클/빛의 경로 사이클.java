import java.util.*;

class Solution {
static char[][] map;
  
  static int row, col;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static boolean[][][] visited;

  static List<Integer> result = new ArrayList<>();

  class Node{
    int x;
    int y;
    int type;

    Node(int x, int y, int type) {
      this.x = x;
      this.y = y;
      this.type = type;
    }
  }

  public int[] solution(String[] grid) {
    row = grid.length;
    col = grid[0].length();
    visited = new boolean[row][col][4];
    paintMap(grid);

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        for(int type = 0; type < 4; type++) {
          if(!visited[i][j][type]) {
            bfs(i, j, type);
          }
        }
      }
    }

    int[] answer = result.stream().sorted()
        .mapToInt(Integer::intValue).toArray();

    return answer;
  }

  private void paintMap(String[] grid) {
    map = new char[row][col];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        map[i][j] = grid[i].charAt(j);
      }
    }
  }

  private void bfs(int a, int b, int type) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(a, b, type));
    visited[a][b][type] = true;
    int count = 1;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      int nowType = node.type;

      int nextX = node.x + dx[nowType];
      int nextY = node.y + dy[nowType];
      int nextType = 0;

      // 경계값
      if(nextX == row) nextX = 0;
      if(nextY == col) nextY = 0;
      if(nextX == -1) nextX = row - 1;
      if(nextY == -1) nextY = col - 1;

      char nextText = map[nextX][nextY];

      if(nextText == 'S') {
        nextType = nowType;
      } else if(nextText == 'L') {
        if(nowType == 0) nextType = 3;
        else nextType = nowType - 1;
      } else {
        nextType = (nowType + 1) % 4;
      }

      if(visited[nextX][nextY][nextType]) continue;

      visited[nextX][nextY][nextType] = true;
      count++;
      queue.add(new Node(nextX, nextY, nextType));
    }
    result.add(count);
  }
}