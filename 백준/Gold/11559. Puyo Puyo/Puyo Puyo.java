import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge {
		int x;
		int y;
		
		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean[][] visited;
	static char[][] map = new char[12][6];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	static ArrayList<Edge> group_list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<12; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<6; j++) {
				map[i][j] = temp[j];
			}
		}
		
		while(true) {
			
			boolean flag = true;
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(map[i][j] != '.') {
						visited = new boolean[12][6];
						isExist(i, j);
					}
				}
			}
			
			if(group_list.size() >= 4) {
				result++;
				flag = false;
				
				for(Edge e : group_list) {
					map[e.x][e.y] = '.'; 
				}
				
				for(int y=0; y<6; y++) {
					char[][] temp = new char[12][1];
					int index = 11;
					
					for(int x=0; x<12; x++) {
						temp[x][0] = '.';
					}
					
					for(int x=11; x>=0; x--) {
						if(map[x][y] == '.') continue;
						
						if(temp[index][0] == '.') {
							temp[index--][0] = map[x][y];
						}
						
					}
					
					for(int x=0; x<12; x++) {
						map[x][y] = temp[x][0];
					}
				}
				
				group_list = new ArrayList<>();
			}
			
			
			if(flag) break;
			
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void isExist(int a, int b) {
		
		ArrayList<Edge> temp = new ArrayList<>();
		
		Queue<Edge> queue = new LinkedList<>();
		queue.add(new Edge(a, b));
		visited[a][b] = true;
		temp.add(new Edge(a, b));
		
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			int x = e.x;
			int y = e.y;
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= 12 || yy < 0 || yy >= 6) continue;
				
				if(visited[xx][yy] || map[x][y] != map[xx][yy]) continue;
				
				visited[xx][yy] = true;
				queue.add(new Edge(xx, yy));
				temp.add(new Edge(xx, yy));
			}
		}
		
		if(temp.size() >= 4) {
			for(Edge e : temp) {
				group_list.add(e);
			}
		}
		
	}
	
	
	
}