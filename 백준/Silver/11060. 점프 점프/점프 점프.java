import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[1001];
		int[] array = new int[1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 0;
		
		for(int i=1; i<=n; i++) {
			int jump = array[i];
			for(int j=i+1; j<=i+jump; j++) {
				if(j <= n) {
					dp[j] = Math.min(dp[j], dp[i]+1);
				}
			}
		}
		
		if(dp[n] >= Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(dp[n]);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}