class Solution {
  public long solution(int n, int[] times) {
    long answer = 0;

    answer = binarySearch(n, times);

    return answer;
  }

  private long binarySearch(int n, int[] times) {
    long left = 1;
    long right = 1000000000L * 1000000000;

    while(left <= right) {
      long mid = left + (right - left) / 2;

      long count = 0;
      for(int time : times) {
        count += mid / time;
      }

      if(count < n) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}