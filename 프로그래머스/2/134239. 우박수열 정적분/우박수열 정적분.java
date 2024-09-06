import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

    ArrayList<Integer> graph = new ArrayList<>();
    ArrayList<Double> integral = new ArrayList<>();
    graph.add(k);

    while(k > 1) {
      if(k % 2 == 0) {
        k /= 2;
      } else {
        k = k * 3 + 1;
      }
      graph.add(k);
    }

    for(int i = 1; i < graph.size(); i++) {
      int now = graph.get(i);
      int prev = graph.get(i-1);
      int heightDif = Math.abs(now - prev);
      int minHeight = Math.min(now, prev);

      double result = heightDif / 2.0 + minHeight;
      integral.add(result);
    }

    for(int index = 0; index < ranges.length; index++) {
      int start = ranges[index][0];
      int end = integral.size() + ranges[index][1];

      if(start > end) {
        answer[index] = -1.0;
        continue;
      }

      double result = 0;
      for(int i = start; i < end; i++) {
        result += integral.get(i);
      }
      answer[index] = result;
    }
        return answer;
    }
}