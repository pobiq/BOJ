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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n][m];
		
		int result = 0;
		
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<m; j++) {
				dp[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(dp[i-1][j-1] > 0 && dp[i-1][j] > 0 && dp[i-1][j] > 0 && dp[i][j] > 0) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(result < dp[i][j]) {
					result = dp[i][j];
				}
			}
		}
		
		sb.append(result*result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}