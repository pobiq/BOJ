import java.util.*;

class Solution {
  public long solution(int n, int[] works) {
    long answer = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for(int work : works) {
      pq.add(work);
    }

    for(int i = 0; i < n; i++) {
      if(!pq.isEmpty()) {
        int mostWork = pq.poll();
        mostWork -= 1;
        if(mostWork > 0) {
          pq.add(mostWork);
        }
      }
    }

    while(!pq.isEmpty()) {
      int mostWork = pq.poll();
      answer += (long) Math.pow(mostWork, 2);
    }

    return answer;
  }
}