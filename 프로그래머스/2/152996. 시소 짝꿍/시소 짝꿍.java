import java.util.*;

class Solution {
  public long solution(int[] weights) {
    long answer = 0;

    Arrays.sort(weights);

    HashMap<Double, Integer> hm = new HashMap<>();

    for(int weight : weights) {
      double case1 = weight * 1.0;
      double case2 = weight * 1.0 / 2.0;
      double case3 = weight * 2.0 / 3.0;
      double case4 = weight * 3.0 / 4.0;

      if(hm.containsKey(case2)) answer += hm.get(case2);
      if(hm.containsKey(case3)) answer += hm.get(case3);
      if(hm.containsKey(case4)) answer += hm.get(case4);
      if(hm.containsKey(case1)) answer += hm.get(case1);
      hm.put(case1, hm.getOrDefault(case1, 0) + 1);
    }


    return answer;
  }
}