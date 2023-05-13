import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<enemy.length; i++) {
			if(pq.size() < k) {
				pq.add(enemy[i]);
			} else {
                
				int value = 0;
				if(pq.peek() < enemy[i]) {
					value = pq.poll();
                    pq.add(enemy[i]);
				} else {
					value = enemy[i];
				}
                
                if(n - value >= 0) {
					n -= value;
				} else {
					return i;
				}
                
			}
		}
        
        return enemy.length;
    }
}