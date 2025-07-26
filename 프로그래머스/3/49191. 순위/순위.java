class Solution {
    
    static int[][] graph;
    static int row = 0;
    static int col = 0;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n][n];

    row = results.length;
    col = results[0].length;

    for (int i = 0; i < row; i++) {
      int a = results[i][0] - 1;
      int b = results[i][1] - 1;
      graph[a][b] = 1;
      graph[b][a] = -1;
    }


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for(int k = 0; k < n; k++) {
          
          if(graph[i][k] == 1 && graph[k][j] == 1) {
            graph[i][j] = 1;
            graph[j][i] = -1;
          }
          
          if(graph[i][k] == -1 && graph[k][j] == -1) {
            graph[i][j] = -1;
            graph[j][i] = 1;
          }
          
        }
      }
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if(graph[i][j] != 0) count++;
      }
      if(count == n-1) answer++;
    }
        
        return answer;
    }
}