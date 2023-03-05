import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int value = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int count =  Integer.parseInt(br.readLine());
		int N = 0;
		int[] array = new int[count];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<count; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		N = array[0] * array[count-1];
		
		sb.append(N);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}