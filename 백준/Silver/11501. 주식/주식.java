import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			long result = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			int[] array = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = array[N-1];
			
			for(int i=N-1; i>=0; i--) {
				if(max > array[i]) {
					result += max - array[i];
				} else if(max < array[i]) {
					max = array[i];
				}
			}
			
			sb.append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}