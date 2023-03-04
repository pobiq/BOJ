import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int white = 0;
	static int blue = 0;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count(0, 0, N);
		
		sb.append(white).append("\n");
		sb.append(blue);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static boolean check(int x, int y, int N) {
		boolean flag = true;
		int main = paper[x][y];
		
		loop:
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(paper[i][j] != main) {
					flag = false;
					break loop;
				}
			}
		}
		
		return flag;
	}
	
	public static void count(int x, int y, int N) {
		int main = paper[x][y];
		
		if(check(x, y, N)) {
			
			if(main == 0) {
				white++;
			} else if(main == 1){
				blue++;
			}
			
		} else {
			count(x, y, N/2);
			count(x+N/2, y, N/2);
			count(x, y+N/2, N/2);
			count(x+N/2, y+N/2, N/2);
		}
		
	}
	
}