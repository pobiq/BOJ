import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
		
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		long sum1 = 0;
		long sum2 = 0;
		long sum = 0;
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0; i<queue1.length; i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
			sum1 += queue1[i];
			sum2 += queue2[i];
		}
		
		sum = sum1 + sum2;
		sum /= 2;
		
		
		while(count1 <= queue1.length*2 && count2 <= queue2.length*2) {
			if(sum1 == sum) {
				answer = count1 + count2;
				break;
			}
			
			if(sum1 > sum) {
				int value = q1.poll();
				q2.add(value);
				count1++;
				sum1 -= value;
				sum2 += value;
			} else if(sum1 < sum) {
				int value = q2.poll();
				q1.add(value);
				count2++;
				sum1 += value;
				sum2 -= value;
			}
			
		}
        
        return answer;
    }
}