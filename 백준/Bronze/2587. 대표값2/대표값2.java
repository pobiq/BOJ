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
		
		int[] array = new int[5];
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			array[i] = Integer.parseInt(br.readLine());
			sum += array[i];
		}
		
		Arrays.sort(array);
		
		sb.append(sum/5).append("\n");
		sb.append(array[2]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}