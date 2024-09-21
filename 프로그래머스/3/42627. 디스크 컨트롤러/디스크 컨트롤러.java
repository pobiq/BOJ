import java.util.*;

class Solution {
  public int solution(int[][] jobs) {
    int answer = 0;

    Arrays.sort(jobs, (o1, o2) -> {
      return o1[0] - o2[0];
    });

    int index = 0;
    int nowTime = 0;
    int totalTime = 0;
    int n = jobs.length;
    int count = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    while(count < n) {

      while(index < n && jobs[index][0] <= nowTime) {
        pq.add(jobs[index++]);
      }

      if(pq.isEmpty()) {
        nowTime = jobs[index][0];
      } else {
        int[] job = pq.poll();
        nowTime += job[1];
        totalTime += nowTime - job[0];
        count++;
      }

    }

    answer = totalTime / n;

    return answer;
  }
}