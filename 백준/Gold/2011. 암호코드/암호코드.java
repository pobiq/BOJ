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
		
		String pw = br.readLine();
		
		int n = pw.length();
		int[] array = new int[n+1];
		
		String[] temp = pw.split("");
		
		for(int i=1; i<=n; i++) {
			array[i] = Integer.parseInt(temp[i-1]);
		}
		
		int[] dp = new int[n+1];
		boolean flag = false;
		
		dp[0] = 1;
		
		if(array[1] == 0) {
			flag = true;
		} else {
			dp[1] = 1;
			for(int i=2; i<=n; i++) {
				if(array[i] > 0) dp[i] = (dp[i] + dp[i-1]) % 1000000;
				
				int value = array[i-1] * 10 + array[i];
				
				if(value >= 10 && value <= 26) {
					dp[i] = (dp[i] +  dp[i-2]) % 1000000;
				} else {
					if(array[i] == 0) {
						flag = true;
						break;
					}
				}
			}
		}
		
		
		
		if(flag) {
			sb.append(0);
		} else {
			sb.append(dp[n]);
		}
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}