import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

    List<Integer> list = new ArrayList<>();

    for(int i = 1; i <= yellow; i++) {
      if(yellow % i == 0) {
        list.add(i);
      }
    }
    
    for(int i = list.size()-1; i >= list.size()/2; i--) {
      int width = list.get(i);
      int height = list.get(list.size()-1-i);

      int brownCount = 2 * width + (height + 2) * 2;
      if(brownCount == brown) {
        answer[0] = width + 2;
        answer[1] = height + 2;
      }
    }
        return answer;
    }
}