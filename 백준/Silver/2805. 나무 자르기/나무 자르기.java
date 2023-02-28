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
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long[] array = new long[N];
		long answer = 0;
		
		long left = 0;
		long right = Long.MIN_VALUE;
		long mid = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			
			if(right < array[i]) {
				right = array[i];
			}
		}
		
		Arrays.sort(array);
		
		while(left < right) {
			mid = (left + right) / 2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(array[i] > mid) {
					sum += (array[i] - mid);
				}
			}
			
			if(sum >= M) {
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