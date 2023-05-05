import java.io.*;
import java.util.*;

public class Main {
	
	static int[][][] dp = new int[101][101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) break;
			
			int result = w(a+50, b+50, c+50);
			
			sb.append("w(" + a + ", " + b + ", " + c +") = ");
			sb.append(result);
			sb.append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static int w(int a, int b, int c) {
		
		if(dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if(a <= 50 || b <= 50 || c <= 50) {
			return dp[a][b][c] = 1;
		}
		
		if(a > 70 || b > 70 || c > 70) {
			return dp[a][b][c] = w(70, 70, 70);
		}
		
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		
	}
	
	
	
}