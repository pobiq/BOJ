import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[10001];
		
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		
		for(int i=2; i<=10000; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		sb.append(dp[n]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}