import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int max = -1;
		
		ArrayList<Integer>[] map = new ArrayList[n+1];
		int[] dist = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<edge.length; i++) {
			int x = edge[i][0];
			int y = edge[i][1];
			map[x].add(y);
			map[y].add(x);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		dist[1] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(max < dist[now]) {
				max = dist[now];
				answer = 1;
			} else if(max == dist[now]) {
				answer++;
			}
			
			for(int i=0; i<map[now].size(); i++) {
				int next = map[now].get(i);
				
				if(dist[next] == 0) {
					dist[next] = dist[now] + 1;
					queue.add(next);
				}
				
			}
		}
        
        return answer;
    }
}