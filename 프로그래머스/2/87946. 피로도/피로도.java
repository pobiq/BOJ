class Solution {
    int answer = 0;

  public int solution(int k, int[][] dungeons) {

    boolean[] visited = new boolean[dungeons.length];

    recursive(k, dungeons, visited, 0);

    return answer;
  }

  private void recursive(int k, int[][] dungeons, boolean[] visited,
      int clear) {

    answer = Math.max(answer, clear);

    for(int i = 0; i < dungeons.length; i++) {
      if(!visited[i] && k >= dungeons[i][0]) {
        visited[i] = true;
        recursive(k - dungeons[i][1], dungeons, visited, clear+1);
        visited[i] = false;
      }
    }

  }
}