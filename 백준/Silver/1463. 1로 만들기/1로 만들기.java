import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] dp = new int[1000001];
        int n = Integer.parseInt(br.readLine());
        
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<=1000000; i++) {
        	
        	if(i % 2 == 0 && i % 3 == 0) {
        		dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1]) + 1;
        	} else if(i % 3 == 0) {
        		dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
        	} else if(i % 2 == 0) {
        		dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
        	} else {
        		dp[i] = dp[i-1] + 1;
        	}
        }
        
        bw.write(Integer.toString(dp[n]));
        
        bw.flush();
		br.close();
		bw.close();
	}
	
}