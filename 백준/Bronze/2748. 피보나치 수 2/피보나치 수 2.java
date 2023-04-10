import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		long result = dp[N];
		
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}