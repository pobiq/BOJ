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
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][3];
		
		int max = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + map[i][0]; 
			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + map[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + map[i][2];
 		}
		
		for(int i=0; i<3; i++) {
			if(max < dp[n-1][i]) {
				max = dp[n-1][i];
			}
		}
		
		dp = new int[n][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0]; 
			dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][2];
 		}
		
		for(int i=0; i<3; i++) {
			if(min > dp[n-1][i]) {
				min = dp[n-1][i];
			}
		}
		
		sb.append(max + " " + min);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}