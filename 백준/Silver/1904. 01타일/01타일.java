import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i=4; i<=n; i++) {
			dp[i] = ((dp[i-1] % 15746) + (dp[i-2] % 15746)) % 15746;
		}
		
		sb.append(dp[n]);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}