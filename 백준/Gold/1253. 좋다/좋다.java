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
		
		int result = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<N; i++) {
			int temp = array[i];
			int left = 0;
			int right = N-1;
			
			while(true) {
				if(left == i) left++;
				else if(right == i) right--;
				
				if(left >= right) break;
				
				if(array[left] + array[right] < temp) {
					left++;
				} else if(array[left] + array[right] == temp) {
					result++;
					break;
				} else {
					right--;
				}
			}
			
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}