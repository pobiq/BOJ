import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] score = new int[n];
		double[] result = new double[n];
		int max = 0;
		
		double answer = 0.0;
		double sum = 0.0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(max < score[i]) {
				max = score[i];
			}
		}
		
		
		for(int i=0; i<n; i++) {
			result[i] = (double)score[i] / (double)max * 100.0;
		}
		
		for(double d : result) {
			sum += d;
		}
		
		answer = sum / (double)n;
		
		sb.append(answer);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}