import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dp[i][j] += dp[i][j-1];
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for(int a=x1; a<=x2; a++) {
				sum += dp[a][y2];
				sum -= dp[a][y1-1];
				
			}
			
			sb.append(sum + "\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}