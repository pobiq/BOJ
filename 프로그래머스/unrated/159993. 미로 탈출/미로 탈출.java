import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int[][] graph;
	static int row, col;
	static int startX, startY, endX, endY, leverX, leverY;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        row = maps.length;
		col = maps[0].length();
		
		graph = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i=0; i<row; i++) {
			char[] temp = maps[i].toCharArray();
			for(int j=0; j<col; j++) {
				if(temp[j] == 'S') {
					startX = i;
					startY = j;
					graph[i][j] = 0;
				} else if(temp[j] == 'E') {
					endX = i;
					endY = j;
					graph[i][j] = 0;
				} else if(temp[j] == 'X') {
					graph[i][j] = -1;
				} else if(temp[j] == 'L'){
					leverX = i;
					leverY = j;
					graph[i][j] = 0;
				} else {
					graph[i][j] = 0;
				}
			}
		}
		
		int distLever = 0;
		int distGoal = 0;
		
		findLever();
		
		distLever = graph[leverX][leverY];
		
		if(distLever == 0 || distLever == -1) {
			return -1;
		}
		
		visited = new boolean[row][col];
		
		graph[leverX][leverY] = 0;
		
		findGoal();
		
		distGoal = graph[endX][endY];
		
		if(distGoal == 0 || distGoal == -1) {
			return -1;
		}
		
		answer = distLever + distGoal;
        
        return answer;
    }
    
    static void findLever() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			if(x == leverX && y == leverY) break;
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= row || yy < 0 || yy >= col) continue;
				
				if(visited[xx][yy] || graph[xx][yy] == -1) continue;
				
				visited[xx][yy] = true;
				graph[xx][yy] = graph[x][y] + 1;
				queue.add(new int[] {xx, yy});
			}
			
		}
	}
	
	static void findGoal() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {leverX, leverY});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			if(x == endX && y == endY) break;
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= row || yy < 0 || yy >= col) continue;
				
				if(visited[xx][yy] || graph[xx][yy] == -1) continue;
				
				visited[xx][yy] = true;
				graph[xx][yy] = graph[x][y] + 1;
				queue.add(new int[] {xx, yy});
			}
			
		}
	}
    
}