import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int result = 0;
		
		int N = Integer.parseInt(br.readLine());
		int max = -1;
		
		int[][] array = new int[N+2][2];
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<=N+1; i++) {
			
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int next = i + array[i][0];
			if(next <= N+1) {
				dp[next] = Math.max(dp[next], max+array[i][1]);
			}
			
		}
 		
		
		
		result = dp[N+1];
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}