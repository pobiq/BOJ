import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		int[] numbers = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N+1][21];
		dp[1][numbers[1]] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j] != 0) {
					if(j + numbers[i] <= 20) {
						dp[i][j + numbers[i]] += dp[i-1][j];
					}
					
					if(j - numbers[i] >= 0) {
						dp[i][j - numbers[i]] += dp[i-1][j];
					}
				}
			}
		}

		result = dp[N-1][numbers[N]];

		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}