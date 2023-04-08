import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static List<int[]> seq = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 3, 2);
		int[][] answer = new int[seq.size()][2];
		
		for(int i=0; i<seq.size(); i++) {
			int[] temp = seq.get(i);
			answer[i][0] = temp[0];
			answer[i][1] = temp[1];
		}
        
        return answer;
    }
    
    static void hanoi(int n, int start, int end, int via) {
		int[] move = {start, end};
		
		if(n == 1) {
			seq.add(move);
		} else {
			hanoi(n-1, start, via, end);
			seq.add(move);
			hanoi(n-1, via, end, start);
		}
		
	}
    
}