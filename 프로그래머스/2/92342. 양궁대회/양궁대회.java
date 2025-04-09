public class Solution {

  static int[] answer = new int[11];

  static int maxDiff = 0;

  public int[] solution(int n, int[] info) {

    int[] output = new int[11];

    recursive(n, info, output, 0, 0);

    if(maxDiff == 0) {
      answer = new int[]{-1};
    }

    return answer;
  }

  private void recursive(int n, int[] info, int[] output, int index, int k) {
    if(index == 11) {
        
        output[10] = 0;
      // 남은 화살 0점에 쏘기
      if(k < n) {
        output[10] = n - k;
      }
      result(info, output);
      return;
    }

    // 1. 어피치를 이길때
    if(n - k > info[index]) {
      output[index] = info[index] + 1;
      recursive(n, info, output, index+1, k + info[index] + 1);
      output[index] = 0;
    }

    // 2. 안쏘고 넘어갈때

    recursive(n, info, output, index+1, k);

  }

  private void result(int[] info, int[] output) {
    int apeach_score = 0;
    int lion_score = 0;

    for(int i = 0; i < 11; i++) {
      if(info[i] == 0 && output[i] == 0) continue;

      if(info[i] >= output[i]) {
        apeach_score += 10 - i;
      } else if(info[i] < output[i]){
        lion_score += 10 - i;
      }
    }

    int diff = lion_score - apeach_score;

    if(maxDiff < diff) {
      maxDiff = diff;
      answer = output.clone();
    } else if(maxDiff == diff) {
      for(int i = 10; i >= 0; i--) {
        if(answer[i] < output[i]) {
          answer = output.clone();
          break;
        } else if(answer[i] > output[i]) return;
      }
    }

  }


}