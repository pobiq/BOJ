import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[M][N];
		
		int count = 0;
		
		int[] answer = new int[2];
		answer[0] = Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(min > array[i][j]) {
					min = array[i][j];
				}
				
				if(max < array[i][j]) {
					max = array[i][j];
				}
			}
		}
		
		for(int height=min; height<=max; height++) {
			int temp_B = B;
			count = 0;
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(height < array[i][j]) {
						temp_B += (array[i][j] - height);
						count += (array[i][j] - height) * 2;
					} else if(height > array[i][j]) {
						temp_B -= (height - array[i][j]);
						count += (height - array[i][j]);
					}
				}
			}
			
			if(temp_B >= 0) {
				if(answer[0] > count) {
					answer[0] = count;
					answer[1] = height;
				} else if(answer[0] == count) {
					if(answer[1] < height) {
						answer[1] = height;
					}
				}
			}
			
		}
		
		
		
		sb.append(answer[0] + " " + answer[1]);
		
		System.out.println(sb);
		
	}

}