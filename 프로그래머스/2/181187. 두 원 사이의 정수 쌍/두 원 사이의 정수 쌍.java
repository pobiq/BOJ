class Solution {
    public long solution(int r1, int r2) {
        long answer = 1;

    for(int x = 1; x < r2; x++) {
      double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
      double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
      int x1 = (int) Math.ceil(y1);
      int x2 = (int) y2;
      answer += x2 - x1 + 1;
    }

    answer *= 4;
        
        return answer;
    }
}