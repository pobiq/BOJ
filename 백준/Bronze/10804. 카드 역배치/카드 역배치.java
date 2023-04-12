import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int[] cards = new int[21];
		
		for(int i=1; i<=20; i++) {
			cards[i] = i;
		}
		
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int limit = (a+b)/2;
			
			for(int j=a; j<=limit; j++) {
				int start_index = j;
				int end_index = b - (j - a);
				int temp = cards[start_index];
				cards[start_index] = cards[end_index];
				cards[end_index] = temp;
			}
		}
		
		for(int i=1; i<=20; i++) {
			sb.append(cards[i] + " ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}