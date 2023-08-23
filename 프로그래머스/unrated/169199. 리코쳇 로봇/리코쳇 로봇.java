import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static class Node {
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		int x;
		int y;
		int value;
	}
	
	static char[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int startX = 0;
	static int startY = 0;
	static int goalX = 0;
	static int goalY = 0;
	static int n = 0;
	static int m = 0;
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
		m = board[0].length();
		
		map = new char[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		
		for(int i=0; i<n; i++) {
			char[] temp = board[i].toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = temp[j];
				if(map[i][j] == 'R') {
					startX = i;
					startY = j;
					visited[i][j] = true;
				}
				
				if(map[i][j] == 'G') {
					goalX = i;
					goalY = j;
				}
			}
		}
		
		bfs(startX, startY);
		
		if(dist[goalX][goalY] == 0) {
			answer = -1;
		} else {
			answer = dist[goalX][goalY];
		}
        
        return answer;
    }
    
    public static void bfs(int startX, int startY) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(startX, startY, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<4; i++) {
				for(int j=1; j<=m; j++) {
					int xx = node.x + dx[i] * j;
					int yy = node.y + dy[i] * j;
					int new_value = node.value + 1;
					
					if(i == 0) {
						if(xx < 0) break;
						
					} else if(i == 1) {
						if(xx >= n) break;
						
					} else if(i == 2) {
						if(yy < 0) break;
						
					} else {
						if(yy >= m) break;
					}
					
					if(visited[xx][yy]) continue;
					
					if(map[xx][yy] == 'D') break;
					
					if(i == 0) {
						if(xx == 0) {
							visited[xx][yy] = true;
							dist[xx][yy] = new_value;
							q.add(new Node(xx, yy, new_value));
							break;
						}
					} else if(i == 1) {
						if(xx == n-1) {
							visited[xx][yy] = true;
							dist[xx][yy] = new_value;
							q.add(new Node(xx, yy, new_value));
							break;
						}
					} else if(i == 2) {
						if(yy == 0) {
							visited[xx][yy] = true;
							dist[xx][yy] = new_value;
							q.add(new Node(xx, yy, new_value));
							break;
						}
					} else {
						if(yy == m-1) {
							visited[xx][yy] = true;
							dist[xx][yy] = new_value;
							q.add(new Node(xx, yy, new_value));
							break;
						}
					}
					
					if(map[xx+dx[i]][yy+dy[i]] == 'D') {
						visited[xx][yy] = true;
						dist[xx][yy] = new_value;
						q.add(new Node(xx, yy, new_value));
						break;
					}
					
				}
			}
			
		}
	}
    
}