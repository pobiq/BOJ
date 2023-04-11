import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static class Node {
		int x;
		int y;
		int dist;
		
		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
    
    static char[][] map = new char[5][5];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited = new boolean[5][5];
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
		
		for(int i=0; i<5; i++) {
			
			boolean flag = false;
			for(int j=0; j<5; j++) {
				char[] temp = places[i][j].toCharArray();
				for(int k=0; k<5; k++) {
					map[j][k] = temp[k];
				}
			}
			
			Loop:
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					if(map[j][k] == 'P') {
						flag = bfs(j, k);
						if(flag) {
							break Loop;
						}
					}
				}
			}
			
			if(flag) {
				answer[i] = 0;
			} else {
				answer[i] = 1;
			}
			
		}
        
        return answer;
    }
    
    static boolean bfs(int a, int b) {
		ArrayList<Node> answer = new ArrayList<>();
		Queue<Node> queue =new LinkedList<>();
		
		queue.add(new Node(a, b, 0));
		visited = new boolean[5][5];
		visited[a][b] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int dist = node.dist;
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				int ddist = dist + 1;
				
				if(xx < 0 || xx >= 5 || yy < 0 || yy >= 5) continue;
				
				if(visited[xx][yy] || map[xx][yy] == 'X') continue;
				
				visited[xx][yy] = true;
				
				if(map[xx][yy] == 'P') {
					if(ddist <= 2) {
						answer.add(new Node(xx, yy, ddist));
					}
				}
				
				queue.add(new Node(xx, yy, ddist));
			}
		}
		
		if(answer.size() > 0) {
			return true;
		}
		
		return false;
		
	}
    
}