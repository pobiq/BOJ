import java.util.*;

class Solution {
    int[][] map;
  boolean[] visited;

  int[] result;

  public int solution(int n, int[][] wires) {
    int answer = Integer.MAX_VALUE;

    int value = 0;

    for(int i = 0; i < wires.length; i++) {
      map = new int[n][n];
      visited = new boolean[n];
      result = new int[2];
      for(int j = 0; j < wires.length; j++) {
        if(i == j) continue;
        int a = wires[j][0] - 1;
        int b = wires[j][1] - 1;
        map[a][b] = 1;
        map[b][a] = 1;
      }


      value = 0;

      for(int start = 0; start < n; start++) {
        if(!visited[start]) {
          BFS(start, n, value);
          value++;
        }
      }
      
      answer = Math.min(answer, Math.abs(result[0] - result[1]));
    }


    return answer;
  }

  private void BFS(int start, int n, int value) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    int sum = 1;

    while(!queue.isEmpty()) {
      int now = queue.poll();

      for(int i = 0; i < n; i++) {

        if(map[now][i] == 0 || visited[i]) continue;

        visited[i] = true;
        sum++;
        queue.add(i);
      }
    }

    result[value] = sum;

  }
}