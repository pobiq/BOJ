import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			int count = 0;
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] == 1 && visited[j][k] == false) {
						dfs(j, k);
						count++;
					}
				}
			}
			
			bw.write(Integer.toString(count) + "\n");
		}
		
		
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int j, int k) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] array = {j, k};
		q.add(array);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0; i<4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				
				if(x >= 0 && x < M && y >= 0 && y < N) {
					if(visited[x][y] == false && map[x][y] == 1) {
						visited[x][y] = true;
						dfs(x, y);
					}
				}
			}
		}
	}
	
}