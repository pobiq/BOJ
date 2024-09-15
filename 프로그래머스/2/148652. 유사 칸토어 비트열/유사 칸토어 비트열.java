class Solution {
    public int solution(int n, long l, long r) {
    int answer = 0;

    answer = sub(n, l-1, r-1, 0, 0);

    return answer;
  }

  private int sub(int n, long l, long r, int index, long start) {
    if(n == 0) {
      return 1;
    }

    int result = 0;
    long split = ((long) Math.pow(5, n)) / 5;

    for(int i = 0; i < 5; i++) {
      if(i == 2) continue;
      long startNumber = i * split + start;
      long endNumber = (i+1) * split - 1 + start;
      if(startNumber > r || endNumber < l) continue;
      result += sub(n-1, l, r, i, startNumber);
    }

    return result;
  }
}