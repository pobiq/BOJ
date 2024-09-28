class Solution {
  public long solution(int[] sequence) {
    long answer = 0;

    int n = sequence.length;

    long[] dp1 = new long[n];
    long[] dp2 = new long[n];
    long[] pulse1 = new long[n];
    long[] pulse2 = new long[n];

    for(int i = 0; i < n; i++) {
      if(i % 2 == 0) {
        pulse1[i] = -1;
        pulse2[i] = 1;
      } else {
        pulse1[i] = 1;
        pulse2[i] = -1;
      }
    }

    dp1[0] = pulse1[0] * sequence[0];
    answer = dp1[0];

    for(int i = 1; i < n; i++) {
      dp1[i] = Math.max(pulse1[i] * sequence[i],
          dp1[i-1] + pulse1[i] * sequence[i]);
      answer = Math.max(answer, dp1[i]);
    }

    dp2[0] = pulse2[0] * sequence[0];
    answer = Math.max(answer, dp2[0]);
    
    for(int i = 1; i < n; i++) {
      dp2[i] = Math.max(pulse2[i] * sequence[i],
          dp2[i-1] + pulse2[i] * sequence[i]);
      answer = Math.max(answer, dp2[i]);
    }
    
    return answer;
  }
}