class Solution {
    public int[] solution(int[] sequence, int k) {
        int answer_start = 0;
		int answer_end = 0;
		
		int start = 0;
		int end = 0;
		
		int sum = sequence[0];
		
		int distance = 1000001;
		
		while(start < sequence.length) {
			
			if(end == sequence.length-1) {
				if(sum < k) {
					break;
				}
			}
			
			if(sum < k) {
				end++;
				sum += sequence[end];
			} else if(sum > k) {
				sum -= sequence[start];
				start++;
			} else {
				if(distance > end - start) {
					distance = end - start;
					answer_start = start;
					answer_end = end;
				}
				sum -= sequence[start];
				start++;
			}
			
		}
		
		int[] answer = new int[]{answer_start, answer_end};
        return answer;
    }
}