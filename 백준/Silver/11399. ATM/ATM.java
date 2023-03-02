import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] time = new int[N];
		int answer = 0;
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		for(int i=0; i<N; i++) {
			sum += time[i];
			answer += sum;
		}
		
		sb.append(answer);
		
		System.out.println(sb);
		
	}
	
	

}