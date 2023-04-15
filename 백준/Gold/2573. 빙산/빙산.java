import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int result = 0;
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int area = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node {
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		
		while(true) {
			area = 0;
			visited = new boolean[N][M];
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(!visited[a][b] && map[a][b] > 0) {
						visited[a][b] = true;
						bfs(a, b);
					}
				}
			}
			
			if(area > 1) {
				result = year;
				break;
			} else if(area == 0) {
				result = 0;
				break;
			}
			
			ArrayList<Node> list = new ArrayList<>();
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(map[a][b] > 0) {
						int count = 0;
						for(int k=0; k<4; k++) {
							int aa = a + dx[k];
							int bb = b + dy[k];
							
							if(aa < 0 || aa >= N || bb < 0 || bb >= M) continue;
							
							if(map[aa][bb] != 0) continue; 
							
							count++;
						}
						list.add(new Node(a, b, count));
					}
				}
			}
			
			for(int a=0; a<list.size(); a++) {
				Node node = list.get(a);
				if(map[node.x][node.y] < node.count) {
					map[node.x][node.y] = 0;
				} else {
					map[node.x][node.y] -= node.count; 
				}
			}
			
			year++;
			
		}
		
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a, b});
		
		area++;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				
				if(visited[xx][yy] || map[xx][yy] == 0) continue;
				
				visited[xx][yy] = true;
				queue.add(new int[] {xx,yy});
				
			}
			
		}
	}
	
}