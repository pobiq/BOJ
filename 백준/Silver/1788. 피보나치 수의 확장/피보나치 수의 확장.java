import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		long[] dp = new long[2000001];
		
		int n = Integer.parseInt(br.readLine());
		
		dp[1000001] = 1;
		dp[1000000] = 0;
		for(int i=999999; i>=0; i--) {
			dp[i] = ((dp[i+2] % 1000000000) - (dp[i+1] % 1000000000)) % 1000000000;
		}
		
		for(int i=1000002; i<=2000000; i++) {
			dp[i] = ((dp[i-1] % 1000000000)+ (dp[i-2] % 1000000000)) % 1000000000;
		}
		
		long result = dp[n+1000000];
		
		if(result > 0) {
			sb.append(1);
		} else if(result == 0) {
			sb.append(0);
		} else {
			sb.append(-1);
		}
		sb.append("\n");
		
		sb.append(Math.abs(result));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}