import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int[][] map;
	static boolean[] visited;
	static int[] count = new int[2];
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
		
		for(int i=0; i<wires.length; i++) {
			map = new int[n][n];
			visited = new boolean[n];
			for(int j=0; j<wires.length; j++) {
				if(i == j) continue;
				int x = wires[j][0] - 1;
				int y = wires[j][1] - 1;
				map[x][y] = map[y][x] = 1;
			}
			
			int index = 0;
			
			for(int j=0; j<n; j++) {
				if(!visited[j]) {
					int value = func(j, map, visited);
					count[index++] = value;
				}
			}
			
			int result = Math.abs(count[1] - count[0]);
			
			if(answer > result) {
				answer = result;
			}
		}
        
        return answer;
    }
    
    static int func(int start, int[][]map , boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		int result = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<map[now].length; i++) {
				if(map[now][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					result++;
				}
			}
		}
		
		return result;
	}
    
}