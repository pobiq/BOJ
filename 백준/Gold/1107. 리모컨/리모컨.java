import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int result = Math.abs(N - 100);
		
		boolean[] broken = new boolean[10];
        
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int n = Integer.parseInt(st.nextToken());
				broken[n] = true;
			}
		}
		
		for(int i=0; i <= 999999; i++) {
			String number = String.valueOf(i);
			
			boolean flag = false;
			
			for(int j=0; j<number.length(); j++) {
				int c = number.charAt(j) - '0';
				
				if(broken[c]) {
					flag = true;
					break;
				}
				
			}
			
			if(!flag) {
				int value = number.length() + Math.abs(N - i);
				result = Math.min(result, value);
			}
			
		}
		
		
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}