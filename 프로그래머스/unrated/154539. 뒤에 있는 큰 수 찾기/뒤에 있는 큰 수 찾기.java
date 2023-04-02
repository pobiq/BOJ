import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
		
		Stack<int[]> stack = new Stack<>();
		
		stack.push(new int[] {0, numbers[0]});
		
		for(int i=1; i<numbers.length; i++) {
			if(stack.isEmpty()) {
				stack.push(new int[] {i, numbers[i]});
			} else {
				while(!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
					answer[stack.pop()[0]] = numbers[i];
				}
				stack.push(new int[] {i, numbers[i]});
			}
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop()[0]] = -1;
		}
        
        return answer;
    }
}