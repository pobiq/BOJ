import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int suttleTime = 9 * 60 - t;
        int count = 0;
        int resultTime = 9 * 60;
        int lastTime = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String times : timetable) {
            String[] timeSplit = times.split(":");
            int clock = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            pq.add(clock + minute);
        }
        
        for (int i = 0; i < n; i++) {
            count = 0;
            suttleTime += t;
            while(!pq.isEmpty() && pq.peek() <= suttleTime && count < m) {
                lastTime = pq.poll();
                count++;
            }
        }
        
        System.out.println(count);
        
        if(count == m) {
            resultTime = lastTime - 1;
        } else {
            resultTime = suttleTime;
        }
        
        int resultClock = resultTime / 60;
        int resultMinute = resultTime % 60;
        
        answer = String.format("%02d", resultClock) + ":" + String.format("%02d", resultMinute);
        
        return answer;
    }
}