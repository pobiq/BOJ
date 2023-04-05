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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[M+1];
		
		Arrays.fill(dp, -1);
		
		dp[S] = 0;
		
		for(int i=1; i<=N; i++) {
			List<Integer> list = new ArrayList<>();
			
			for(int j=0; j<=M; j++) {
				if(dp[j] == i-1) {
					if(0 <= j+array[i] && j + array[i] <= M) {
						list.add(j+array[i]);
					}
					if(0<= j - array[i] && j - array[i] <= M) {
						list.add(j-array[i]);
					}
				}
			}
			
			for(int n : list) {
				dp[n] = i;
			}
			
		}
		
		int result = -1;
		
		for(int i=0; i<=M; i++) {
			if(dp[i] == N) {
				result = Math.max(result, i);
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}