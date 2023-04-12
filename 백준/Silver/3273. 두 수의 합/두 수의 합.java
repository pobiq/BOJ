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
		
		int n = Integer.parseInt(br.readLine());
		
		int[] array = new int[n];
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		int[] count = new int[2000001];
		
		for(int i=0; i<n; i++) {
			int index = array[i];
			count[index]++;
		}
		
		for(int i=1; i<=x/2; i++) {
			int a = i;
			int b = x-i;
			if(a != b) {
				if(count[a] == 1 && count[b] == 1) {
					result++;
				}
			}
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
