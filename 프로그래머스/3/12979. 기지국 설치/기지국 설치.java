class Solution {
  public int solution(int n, int[] stations, int w) {
    int answer = 0;

    int start = 1;
    int end = 1;
    int width = 2 * w + 1;

    for(int station : stations) {
      end = station - w - 1;
      if(end < start) {
        start = station + w + 1;
        continue;
      }
      int length = end - start + 1;

      answer += length / width;
      if(length % width != 0) answer++;

      start = station + w + 1;
    }

    if(start <= n) {
      end = n;
      int length = end - start + 1;
      answer += length / width;
      if(length % width != 0) answer++;
    }

    return answer;
  }
}