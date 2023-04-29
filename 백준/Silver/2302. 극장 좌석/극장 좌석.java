import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int result = 1;
		
		int[] dp = new int[41];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=40; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int start = 0;
		
		for(int i=0; i<M; i++) {
			int value = Integer.parseInt(br.readLine());
			int length = value - start - 1;
			
			result *= dp[length];
			
			start = value;
		}
		
		result *= dp[N-start];
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}