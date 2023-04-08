import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    static int row,col;
	static String[][] graph;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static int[] dx = {0, 0, -1 ,1};
	static int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[] maps) {
        
        row = maps.length;
		col = maps[0].length();
		
		graph = new String[row][col];
		visited = new boolean[row][col];
		
		for(int i=0; i<row; i++) {
			String[] temp = maps[i].split("");
			for(int j=0; j<col; j++) {
				graph[i][j] = temp[j];
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(!graph[i][j].equals("X") && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		int[] answer = {};
		
		if(list.size() > 0) {
			answer = new int[list.size()];
			
			for(int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
		} else {
			answer = new int[]{-1};
		}
        
        return answer;
    }
    
    static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		
		int sum = Integer.parseInt(graph[i][j]);
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int a=0; a<4; a++) {
				int xx = x + dx[a];
				int yy = y + dy[a];
				
				if(xx < 0 || xx >= row || yy < 0 || yy >= col) continue;
				
				if(visited[xx][yy] || graph[xx][yy].equals("X")) continue;
				
				visited[xx][yy] = true;
				queue.add(new int[] {xx, yy});
				sum += Integer.parseInt(graph[xx][yy]);
				
			}
		}
		
		list.add(sum);
		
	}
    
}