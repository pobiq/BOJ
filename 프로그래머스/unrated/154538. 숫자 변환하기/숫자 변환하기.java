import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] map = new int[1000001];
		boolean[] visited = new boolean[1000001];
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(x);
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now+n <= 1000000 && !visited[now+n]) {
				map[now+n] = map[now] + 1;
				queue.add(now+n);
				visited[now+n] = true;
			}
			
			if(now*2 <= 1000000 && !visited[now*2]) {
				map[now*2] = map[now] + 1;
				queue.add(now*2);
				visited[now*2] = true;
			}
			
			if(now*3 <= 1000000 && !visited[now*3]) {
				map[now*3] = map[now] + 1;
				queue.add(now*3);
				visited[now*3] = true;
			}
			
		}
		
		if(x == y) {
			answer = 0;
		} else {
			answer = map[y] > 0 ? map[y] : -1;
		}
        
        return answer;
    }
}