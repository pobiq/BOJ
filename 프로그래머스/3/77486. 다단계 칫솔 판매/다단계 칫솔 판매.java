import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

    HashMap<String, Integer> profit_hm = new HashMap<>();
    HashMap<String, String> group = new HashMap<>();

    for(String e : enroll) {
      profit_hm.put(e, 0);
    }

    for(int i = 0; i < enroll.length; i++) {
      group.put(enroll[i], referral[i]);
    }

    for(int i = 0; i < seller.length; i++) {
      String child = seller[i];
      int won = amount[i] * 100;

      int child_amount = 0;
      int parent_amount = 0;

      while(true) {

        parent_amount = (int)(won * 0.1);
        child_amount = won - parent_amount;

        profit_hm.put(child, profit_hm.get(child) + child_amount);

        if(parent_amount <= 0) {
          break;
        }

        won = parent_amount;
        child = group.get(child);

        if(child.equals("-")) {
          break;
        }

      }
      
    }

    for(int i = 0; i < enroll.length; i++) {
      answer[i] = profit_hm.get(enroll[i]);
    }

    return answer;
    }
}