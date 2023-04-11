import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (o1, o2) -> {
			
			if(o1[col-1] == o2[col-1]) {
				return o2[0] - o1[0];
			} else {
				return o1[col-1] - o2[col-1];
			}
			
		});
		
		int[] array = new int[row_end-row_begin+1];
		
		for(int i=row_begin-1; i<=row_end-1; i++) {
			int sum = 0;
			for(int j=0; j<data[0].length; j++) {
				sum += data[i][j] % (i+1);
			}
			array[i-row_begin+1] = sum;
		}
		
		int answer = array[0];
		
		for(int i=1; i<array.length; i++) {
			answer = answer^array[i];
		}
        
        return answer;
    }
}