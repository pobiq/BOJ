import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] coins = new int[n];
			
			for(int i=0; i<n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(br.readLine());
			
			int[] dp = new int[m+1];
			dp[0] = 1;
			
			for(int i=0; i<n; i++) {
				int coin = coins[i];
				
				for(int j=coin; j<=m; j++) {
					dp[j] = dp[j] + dp[j - coin];
				}
				
			}
			
			sb.append(dp[m]).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}