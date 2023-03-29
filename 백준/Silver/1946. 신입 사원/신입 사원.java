import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][2];
			int result = 1;
			int score1 = 0;
			int score2 = 0;
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				array[j][0] = Integer.parseInt(st.nextToken());
				array[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(array, (o1, o2) -> {
				return o1[0] - o2[0];
			});
			
			score1 = array[0][0];
			score2 = array[0][1];
			
			for(int j=1; j<N; j++) {
				if(score1 > array[j][0] || score2 > array[j][1]) {
					result++;
					score1 = array[j][0];
					score2 = array[j][1];
				}
			}
			
			
			sb.append(result).append("\n");
		}
		
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}