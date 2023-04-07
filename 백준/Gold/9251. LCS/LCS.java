import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String S = br.readLine();
		String P = br.readLine();
		
		int length1 = S.length();
		int length2 = P.length();
		
		char[] A = S.toCharArray();
		char[] B = P.toCharArray();
		
		int[][] dp = new int[length1+1][length2+1];
		
		for(int i=1; i<=length1; i++) {
			for(int j=1; j<=length2; j++) {
				
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
		}
		
		sb.append(dp[length1][length2]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}