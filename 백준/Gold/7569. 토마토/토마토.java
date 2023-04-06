import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N,H;
	static int[][][] map;
	static int result = 0;
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static int[] di = {0, 0, 0, 0, -1, 1};
	static int[] dj = {0, 0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int h = temp[0];
			int i = temp[1];
			int j = temp[2];
			
			for(int x=0; x<6; x++) {
				int hh = h + dh[x];
				int ii = i + di[x];
				int jj = j + dj[x];
				
				if(hh < 0 || hh >= H || ii < 0 || ii >= N || jj < 0 || jj >= M) continue;
				
				if(map[hh][ii][jj] == 0) {
					map[hh][ii][jj] = map[h][i][j] + 1;
					queue.add(new int[] {hh,ii,jj});
				}
			}
		}
		
		boolean flag = false;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					
					if(map[i][j][k] == 0) {
						flag = true;
					}
					
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		
		
		if(flag) {
			sb.append(-1);
		} else {
			if(result == 1) {
				sb.append(0);
			} else {
				sb.append(result-1);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}