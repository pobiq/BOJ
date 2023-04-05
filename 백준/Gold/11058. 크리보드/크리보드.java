import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			if(i <= 6) {
				dp[i] = i;
			} else {
				for(int j=3; j <= i; j++) {
					dp[i] = Math.max(dp[i], dp[i-j] *(j-1));
				}
			}
			
		}
		
		sb.append(dp[N]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}