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
		
		
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Y = 0;
		int M = 0;
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			
			int Ycount = (int)Math.ceil(array[i]/30.0);
			if(array[i] % 30 == 0) {
				Ycount++;
			}
			int Mcount = (int)Math.ceil(array[i]/60.0);
			if(array[i] % 60 == 0) {
				Mcount++;
			}
			
			Y += Ycount*10;
			M += Mcount*15;
		}
		
		
		if(Y > M) {
			sb.append("M" + " " +M);
		} else if(Y < M) {
			sb.append("Y" + " " +Y);
		} else {
			sb.append("Y" + " " + "M" + " " +Y);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}