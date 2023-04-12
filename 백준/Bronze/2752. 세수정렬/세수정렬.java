import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] array = new int[3];
		int min = 1000000;
		int max = 0;
		int middle = 0;
		
		for(int i=0; i<3; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			if(max < array[i]) {
				max = array[i];
			}
			
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		for(int i=0; i<3; i++) {
			if(min < array[i] && array[i] < max) {
				middle = array[i];
			}
		}
		
		
		sb.append(min + " " + middle + " " + max);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}