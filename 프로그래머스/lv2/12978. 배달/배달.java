import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int[] map;
	
	static class Edge {
		int next;
		int value;
		
		public Edge(int next, int value) {
			this.next = next;
			this.value = value;
		}
	}
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        map = new int[N+1];
		Arrays.fill(map, Integer.MAX_VALUE);
		map[1] = 0;
		
		for(int i=0; i<road.length; i++) {
			if(road[i][0] == 1) {
				bfs(road, K, road[i][1], road[i][2]);
			}
			if(road[i][1] == 1) {
				bfs(road, K, road[i][0], road[i][2]);
			}
		}
		
		for(int i : map) {
			if(i <= K) {
				answer++;
			}
		}

        return answer;
    }
    
    public static void bfs(int[][] road, int K, int a, int b) {
		Queue<Edge> queue = new LinkedList<>();
		queue.add(new Edge(a, b));
		map[a] = Math.min(map[a], b);
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			int now = edge.next;
			int value = edge.value;
			
			for(int i=0; i<road.length; i++) {
				if(road[i][0] == now) {
					int next = road[i][1];
					int next_value = value + road[i][2];
					if(map[next] > next_value) {
						map[next] = next_value;
						queue.add(new Edge(next, next_value));
					}
				}
				
				if(road[i][1] == now) {
					int next = road[i][0];
					int next_value = value + road[i][2];
					if(map[next] > next_value) {
						map[next] = next_value;
						queue.add(new Edge(next, next_value));
					}
				}
				
			}
			
		}
		
	}
}