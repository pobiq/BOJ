import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s) {
			return new int[] {-1};
		}
		
		int r = s/n;
		
		Arrays.fill(answer, r);
		
		s -= r*n;
		
		int index = n-1;
		
		while(s > 0) {
			answer[index--]++;
			s--;
		}
        
        return answer;
    }
}