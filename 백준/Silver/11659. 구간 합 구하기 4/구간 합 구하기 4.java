import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		array[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			array[i] = array[i-1] + Integer.parseInt(st.nextToken());
		}

		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			answer = array[b-1];
			
			if(a > 1) {
				answer -= array[a-2];
			}
			
			bw.write(Integer.toString(answer) + "\n");
			
		}
		
		bw.flush();
		bw.close();
		
	}
	
}