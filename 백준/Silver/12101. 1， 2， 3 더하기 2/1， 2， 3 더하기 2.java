import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<String>[] dp = new ArrayList[n+3];
		
		for(int i=0; i<=n+2; i++) {
			dp[i] = new ArrayList<>();
		}
		
		dp[1].add("1");
		dp[2].add("1+1");
		dp[2].add("2");
		dp[3].add("1+1+1");
		dp[3].add("1+2");
		dp[3].add("2+1");
		dp[3].add("3");
		
		
		for(int i=4; i<=n; i++) {
			for(int j=i-1; j>=i-3; j--) {
				for(String s : dp[j]) {
					dp[i].add(s +  "+" + String.valueOf(i-j));
				}
			}
		}
		
		if(dp[n].size() < k) {
			sb.append(-1);
		} else {
			Collections.sort(dp[n]);
			sb.append(dp[n].get(k-1));
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}