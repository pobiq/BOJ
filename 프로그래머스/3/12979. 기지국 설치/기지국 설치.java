public class Solution {
  public int solution(int n, int[] stations, int w) {
    int answer = 0;

    int start = 1;
    int end = 1;

    for(int station : stations) {
      end = station - w - 1;
      int length = end - start + 1;
      answer += (int) Math.ceil((double) length / (2 * w + 1));
      start = station + w + 1;
    }

    if(start <= n) {
      end = n;
      int length = end - start + 1;
      answer += (int) Math.ceil((double) length / (2 * w + 1));
    }

    return answer;
  }

}