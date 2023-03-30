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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;
		int[] array = new int[N];
		int start = 0;
		int end = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = array[0];
		
		
		while(start < N) {
			if(sum < S) {
				if(end < N-1) {
					end++;
					sum += array[end];
				} else {
					sum -= array[start];
					start++;
				}
			} else {
				if(result > end-start+1) {
					result = end-start+1;
				}
				sum -= array[start];
				start++;
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			result = 0;
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}