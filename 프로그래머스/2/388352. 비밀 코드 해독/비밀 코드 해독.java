import java.util.HashSet;

public class Solution {

  static int answer = 0;
  static int length = 0;
  static int m = 0;

  HashSet<Integer>[] sets;

  public int solution(int n, int[][] q, int[] ans) {

    length = n;
    m = ans.length;

    sets = new HashSet[m];
    for(int i = 0; i < m; i++) {
      sets[i] = new HashSet<>();
      for (int j = 0; j < 5; j++) {
        sets[i].add(q[i][j]);
      }
    }

    int[] output = new int[5];
    boolean[] visited = new boolean[length+1];

    dfs(output, visited, 0, 1, ans);

    return answer;
  }

  private void dfs(int[] output, boolean[] visited, int depth, int start,
      int[] ans) {

    if(depth == 5) {
      if(checkAnswer(output, ans)) {
        answer++;
      }
      return;
    }

    for(int i = start; i < length+1; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = i;
        dfs(output, visited, depth + 1, i+1, ans);
        visited[i] = false;
      }
    }
  }

  private boolean checkAnswer(int[] output, int[] ans) {

    for(int i = 0; i < m; i++) {
      int count = 0;
      for (int j = 0; j < 5; j++) {
        if(sets[i].contains(output[j])) count++;
      }
      if(ans[i] != count) return false;
    }

    return true;
  }

}