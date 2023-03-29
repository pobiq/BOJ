import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		Integer[] L = new Integer[N];
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(L, Collections.reverseOrder());
		
		int temp = L[0];
		
		for(int i=1; i<N; i++) {
			if(temp < L[i]) {
				temp = L[i];
			}
			result += (temp+L[i]);
		}
		
		
		sb.append(result);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}