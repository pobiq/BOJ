import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		array = new char[N][N];
		
		recursive(0, 0, N, false);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(array[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void recursive(int x, int y, int N, boolean blank) {
		
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					array[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1) {
			array[x][y] = '*';
			return;
		}
		
		int size = N/3;
		int count = 0;
		for(int i=x; i<x+N; i+=size) {
			for(int j=y; j<y+N; j+=size) {
				count++;
				
				if(count == 5) {
					recursive(i, j, size, true);
				} else {
					recursive(i, j, size, false);
				}
			}
		}

		
	}
	
}