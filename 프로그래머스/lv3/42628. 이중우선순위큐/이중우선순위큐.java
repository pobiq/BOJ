import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		
		PriorityQueue<Integer> lowQueue = new PriorityQueue<>();
		PriorityQueue<Integer> highQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String s : operations) {
			StringTokenizer st = new StringTokenizer(s);
			String order = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			
			if(order.equals("I")) {
				lowQueue.add(number);
			} else {
				if(number == 1) {
					while(!lowQueue.isEmpty()) {
						highQueue.add(lowQueue.poll());
					}
					if(!highQueue.isEmpty()) {
						highQueue.poll();
					}
				} else {
					while(!highQueue.isEmpty()) {
						lowQueue.add(highQueue.poll());
					}
					if(!lowQueue.isEmpty()) {
						lowQueue.poll();
					}
				}
			}
			
			System.out.println(lowQueue + " " + highQueue);
		}
		
		if(highQueue.isEmpty() && lowQueue.isEmpty()) {
			answer[0] = answer[1] = 0;
		} else {
			while(!lowQueue.isEmpty()) {
				highQueue.add(lowQueue.poll());
			}
			answer[0] = highQueue.peek();
			while(!highQueue.isEmpty()) {
				lowQueue.add(highQueue.poll());
			}
			answer[1] = lowQueue.peek();
		}
        
        return answer;
    }
}