import java.util.*;

public class Solution {

  public int solution(int[] diffs, int[] times, long limit) {
    int master = 0;

    int left = 1;
    int right = 0;

    for(int diff : diffs) {
      right = Math.max(right, diff);
    }


    while(left <= right) {
      int mid = left + (right - left) / 2;

      if(isPass(mid, diffs, times, limit)) {
        master = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }

    }

    return master;
  }

  private boolean isPass(int mid, int[] diffs, int[] times, long limit) {
    long timeCount = times[0];

    for(int i = 1; i < diffs.length; i++) {
      int nowDiff = diffs[i];
      int nowTime = times[i];
      if(mid >= nowDiff) {
        timeCount += nowTime;
      } else {
        int prevTime = times[i-1];
        timeCount += (long) (prevTime + nowTime) * (nowDiff - mid) + nowTime;
      }
    }

    return timeCount <= limit;
  }


}