import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] array = new int[K];
		long answer = 0;
		
		long left = 0;
		long right = 0;
		long mid = 0;
		
		for(int i=0; i<K; i++) {
			array[i] = Integer.parseInt(br.readLine());
			
			if(right < array[i]) {
				right = array[i];
			}
			
		}
		
		right++;
		
		while(left < right) {
			mid = (left + right) / 2;
			
			long sum = 0;
			for(int i=0; i<K; i++) {
				sum += (array[i] / mid);
			}
			
			if(sum >= N) {
				left = mid + 1;
			} else {
				right = mid;
			}
			
		}
		
		answer = left - 1;
		
		sb.append(answer);
		
		System.out.println(sb);
		
	}

}