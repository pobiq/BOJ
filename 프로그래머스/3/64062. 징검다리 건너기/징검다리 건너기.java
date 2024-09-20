class Solution {
  public int solution(int[] stones, int k) {
    int answer = 0;

    answer = binarySearch(stones, k);

    return answer;
  }

  private int binarySearch(int[] stones, int k) {
    int left = 1;
    int right = 0;

    for(int station : stones) {
      right = Math.max(right, station);
    }

    while(left <= right) {
      int mid = left + (right - left) / 2;

      if(isPass(stones, mid, k)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return left - 1;
  }
  
  private boolean isPass(int[] stones, int mid, int k) {
    int count = 0;

    for (int stone : stones) {
      if (stone - mid >= 0) {
        count = 0;
      } else {
        count++;
        if(count >= k) {
          return false;
        }
      }
    }

    return true;

  }
}