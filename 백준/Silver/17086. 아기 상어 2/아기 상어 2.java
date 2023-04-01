import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
    static int[][] map;
    static int result = 0;
	
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
				if(map[i][j] == 0) {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 1 && result < map[i][j]) {
					result = map[i][j];
				}
			}
		}
		
		sb.append(result-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
            int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
            
            for(int i=0; i<8; i++) {
            	int xx = temp[0] + dx[i];
            	int yy = temp[1] + dy[i];
            	
            	if(xx >= 0 && xx < N && yy >= 0 && yy <M) {
            		if(map[xx][yy] > map[temp[0]][temp[1]] + 1) {
            			map[xx][yy] = map[temp[0]][temp[1]] + 1;
            			q.offer(new int[] {xx, yy});
            		}
            	}
            }
		}
	}
}