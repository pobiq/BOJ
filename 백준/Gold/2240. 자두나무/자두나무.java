import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] tree = new int[t+1];
		int[][][] dp =  new int[3][t+1][w+2];
		
		for(int i=1; i<=t; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for(int i=1; i<=t; i++) {
			for(int j=1; j<=w+1; j++) {
				// 첫번째 사과나무 일때
				if(tree[i] == 1) {
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) + 1;
					dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]);
				} 
				// 두번째 사과나무 일때
				else {
					
					if(i == 1 && j == 1) continue;
					
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
					dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]) + 1;
				}
			}
		}
		
		
		int result = 0;
		
		for(int i=1; i<=w+1; i++) {
			result = Math.max(result, Math.max(dp[1][t][i], dp[2][t][i]));
		}
		
		sb.append(result);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}