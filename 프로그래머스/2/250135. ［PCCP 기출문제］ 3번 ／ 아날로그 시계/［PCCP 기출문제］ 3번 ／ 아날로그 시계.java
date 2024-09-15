import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    int answer = 0;

    double clock1Second = h1 * 3600 + m1 * 60 + s1;
    double clock2Second = h2 * 3600 + m2 * 60 + s2;

    HashSet<Double> overlapTime = new HashSet();


    for(int minute = 0; minute < 3600; minute++) {
      double time1 = (minute * 60) / 719.0 + 60 * minute;
      double time2 = (minute * 60) / 59.0 + 60 * minute;

      if(time1 >= clock1Second && time1 <= clock2Second) {
        overlapTime.add(time1);
      }

      if(time2 >= clock1Second && time2 <= clock2Second) {
        overlapTime.add(time2);
      }
    }

    answer = overlapTime.size();
    
    return answer;
  }
}