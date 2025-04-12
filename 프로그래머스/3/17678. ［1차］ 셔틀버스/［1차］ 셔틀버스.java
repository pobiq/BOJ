import java.util.PriorityQueue;

public class Solution {

  static int firstShuttleTime = 9*60;

  public String solution(int n, int t, int m, String[] timetable) {
    String answer = "";
    int result = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(String s : timetable) {
      String[] temp = s.split(":");
      pq.add(Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]));
    }

    int shuttleTime = firstShuttleTime - t;
    int count = 0;
    int lastTime = 0;

    for(int i = 0; i < n; i++) {
      shuttleTime += t;
      count = 0;
      while(!pq.isEmpty() && pq.peek() <= shuttleTime && count < m) {
        lastTime = pq.poll();
        count++;
      }
    }

    if(count == m) {
      result = lastTime - 1;
    } else {
      result = shuttleTime;
    }

    answer = String.format("%02d", result / 60)
        + ":" + String.format("%02d", result % 60);

    return answer;
  }

}