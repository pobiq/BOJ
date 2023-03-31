import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Long> list = new ArrayList<>();
	static int N;
	static int count = 0;
	static int[][] house;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 1);
		
		sb.append(count);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int x, int y, int direction) {
		
		if(x == N-1 && y == N-1) {
			count++;
			return;
		}
		
		// 가로 경우
		if(direction == 1) {
			// 가로이동
			if(y+1 < N && house[x][y+1] == 0) {
				dfs(x, y+1, 1);
			}
		// 세로 경우
		} else if(direction == 2) {
			// 세로이동
			if(x+1 < N && house[x+1][y] == 0) {
				dfs(x+1, y, 2);
			}
		// 대각선 경우
		} else if(direction == 3) {
			// 가로이동
			if(y+1 < N && house[x][y+1] == 0) {
				dfs(x, y+1, 1);
			}
			// 세로이동
			if(x+1 < N && house[x+1][y] == 0) {
				dfs(x+1, y, 2);
			}
		}
		// 대각선이동
		if(x + 1 < N && y + 1 < N && house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0) {
			dfs(x+1, y+1, 3);
		}
		
	}
	
}