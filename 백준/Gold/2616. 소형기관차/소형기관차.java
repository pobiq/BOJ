import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] train = new int[n+1];
		int[] sum = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			train[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + train[i];
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[4][n+1];
		
		for(int i=1; i<=3; i++) {
			for(int j=i*k; j<=n; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + sum[j] - sum[j-k]);
			}
		}
		
		sb.append(dp[3][n]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}