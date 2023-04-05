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
		char[] board = new char[N+1];
		
		long result = 0;
		
		char[] temp = br.readLine().toCharArray();
		for(int i=1; i<=N; i++) {
			board[i] = temp[i-1];
		}
		
		Arrays.fill(dp, Long.MAX_VALUE);
		
		dp[1] = 0;
		
		for(int i=1; i<=N; i++) {
			char block = board[i];
			
			for(int j=i+1; j<=N; j++) {
				
				if(dp[i] == Long.MAX_VALUE) break;
				
				switch(block) {
				case 'B':
					if(board[j] == 'O') {
						dp[j] = Math.min(dp[j], dp[i] + (i-j)*(i-j));
					}
					break;
				case 'O':
					if(board[j] == 'J') {
						dp[j] = Math.min(dp[j], dp[i] + (i-j)*(i-j));
					}
					break;
				case 'J':
					if(board[j] == 'B') {
						dp[j] = Math.min(dp[j], dp[i] + (i-j)*(i-j));
					}
					break;
				}
			}
			
		}
		
		result = dp[N] == Long.MAX_VALUE ? -1 : dp[N];
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}