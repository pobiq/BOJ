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
		
		int[][] array = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + array[i][j];
			}
		}
		
		sb.append(dp[n][m]);
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}