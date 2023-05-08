import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = 0;
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			t++;
			
			if(n == 0) {
				break;
			}
			
			int[][] map = new int[n][3];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[n][3];
			
			for(int i=0; i<n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<3; j++) {
					if(i == 0) {
						
						if(j == 1) {
							dp[i][j] = map[i][j];
						} else if(j == 2) {
							dp[i][j] = dp[i][j-1] + map[i][j];
						}
						
					} else {
						
						if(j == 0) {
							dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + map[i][j];
						} else if(j == 1) {
							dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]))) + map[i][j];
						} else {
							dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + map[i][j];
						}
						
					}

				}
			}
			
			sb.append(t+". " + dp[n-1][1]).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}