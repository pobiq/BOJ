import java.util.*;

public class Solution {

  boolean[][] visited;

  int row = 0;
  int col = 0;

  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  int[] areas;

  class Node {
    int x;
    int y;
    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int solution(int[][] land) {

    int answer = 0;

    row = land.length;
    col = land[0].length;
    areas = new int[col];
    visited = new boolean[row][col];

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(!visited[i][j] && land[i][j] == 1) {
          HashSet<Integer> hs = new HashSet<>();
          BFS(land, i, j, hs);
        }
      }
    }

    for(int area : areas) {
      answer = Math.max(answer, area);
    }



    return answer;
  }

  private void BFS(int[][] land, int i, int j, HashSet<Integer> hs) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(i, j));
    visited[i][j] = true;

    int result = 0;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      hs.add(node.y);
      result++;

      for(int a = 0; a < 4; a++) {
        int nextX = node.x + dx[a];
        int nextY = node.y + dy[a];

        if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;

        if(visited[nextX][nextY] || land[nextX][nextY] == 0) continue;
        visited[nextX][nextY] = true;
        queue.add(new Node(nextX, nextY));
      }
    }

    Iterator iter = hs.iterator();

    while(iter.hasNext()) {
      int index = (int) iter.next();
      areas[index] += result;
    }

  }

}