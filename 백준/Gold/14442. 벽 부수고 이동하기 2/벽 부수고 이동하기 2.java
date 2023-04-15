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
	
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	
	static class Node{
		int x;
		int y;
		int k;
		int dist;
		
		public Node(int x, int y, int k, int dist) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		visited[0][0][0] = true;
		bfs(0, 0, 0, 0);
		
		
		boolean flag = false;
		for(int i=0; i<=K; i++) {
			if(visited[N-1][M-1][i]) {
				flag = true;
			}
		}
		
		if(flag) {
			sb.append(result+1);
		} else {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b, int c, int d) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(a, b, c, d));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int k = n.k;
			int dist = n.dist;
			
			if(x == N-1 && y == M-1) {
				result = dist;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				
				// 부술 벽이 남아있는 경우
				if(k < K) {
					// 벽을 만났을때
					if(map[xx][yy] == 1 && !visited[xx][yy][k+1]) {
						visited[xx][yy][k+1] = true;
						queue.add(new Node(xx, yy, k+1, dist+1));
					}
					//벽을 안만났을때
					else if(map[xx][yy] == 0 && !visited[xx][yy][k]){
						visited[xx][yy][k] = true;
						queue.add(new Node(xx, yy, k, dist+1));
					}
					
				}
				// 부술 벽이 없는 경우
				else {
					//벽을 안만났을때
					if(map[xx][yy] == 0 && !visited[xx][yy][k]) {
						visited[xx][yy][k] = true;
						queue.add(new Node(xx, yy, k, dist+1));
					}
				}
				
			}
			
		}
	}
}