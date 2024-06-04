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
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        
        String input = br.readLine();
        
        String[] temp = input.split(" ");
        int[] array = new int[temp.length+1];
        
        for(int i=0; i<temp.length; i++) {
        	array[i+1] = Integer.parseInt(temp[i]);
        }
        
        for(int i=1; i<array.length; i++) {
        	for(int j=1; j<=i; j++) {
        		dp[i] = Math.max(dp[i], dp[i-j] + array[j]);
        	}
        }
        
        bw.write(Integer.toString(dp[N]));
        
        bw.flush();
		br.close();
		bw.close();
	}
	
	
}