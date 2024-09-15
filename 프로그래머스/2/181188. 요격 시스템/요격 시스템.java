import java.util.*;

class Solution {
    public int solution(int[][] targets) {
    int answer = 1;

    Arrays.sort(targets, (o1, o2) -> {
      return o1[1]-o2[1];
    });

    double[][] array = new double[targets.length][2];

    for (int i = 0; i < targets.length; i++) {
      array[i][0] = targets[i][0] + 0.5;
      array[i][1] = targets[i][1] - 0.5;
    }

    double target = array[0][1];

    for(int i = 1; i < array.length; i++) {
      if(target < array[i][0]) {
        answer++;
        target = array[i][1];
      }
    }

    return answer;
  }
    
}