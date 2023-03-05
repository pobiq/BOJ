import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(computers[i][j] == 1 && visited[j] == false) {
        			count(n, computers, visited, i);
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
    
    public static void count(int n, int[][] computers, boolean[] visited, int i) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(i);
		
		while(!q.isEmpty()) {
			int index = q.poll();
			for(int j=0; j<n; j++) {
				if(computers[index][j] == 1 && visited[j] == false) {
					visited[j] = true;
					q.offer(j);
				}
			}
		}
	}
    
}