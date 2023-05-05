import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] array = new int[n+1][2];
		int[] dp = new int[n+2];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			array[i][0] = t;
			array[i][1] = p;
		}
		
		for(int i=n; i>=1; i--) {
			int t = array[i][0];
			int p = array[i][1];
			if(i+t <= n+1) {
				dp[i] = Math.max(dp[i+t] + p, dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
		}
		
		sb.append(dp[1]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}