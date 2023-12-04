import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int[] coin = new int[N];
		int index = 0;
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			if(coin[i] <= K) {
				index = i;
			}
		}
		
		while(K > 0) {
			
			while(K < coin[index]) {
				index--;
			}
			
			K -= coin[index];
			count++;
			
			
		}
		
		sb.append(count);
		
		System.out.println(sb);
		
	}
	
	

}