import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
		
		List<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<nums.length-2; i++) {
			for(int j=i+1; j<nums.length-1; j++) {
				for(int k=j+1; k<nums.length; k++) {
					array.add(nums[i] + nums[j] + nums[k]);
				}
			}
		}
		
		int count = 0;
		
		for(int i : array) {
			for(int j=1; j<=i; j++) {
				if(i%j == 0) {
					count++;
				}
			}
			if(count < 3) {
				answer++;
			}
			count = 0;
		}

        
        
        return answer;
    }
}