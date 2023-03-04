import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int minus = 0;
	static int zero = 0;
	static int one = 0;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count(0, 0, N);
		
		bw.write(Integer.toString(minus) + "\n");
		bw.write(Integer.toString(zero) + "\n");
		bw.write(Integer.toString(one));
		
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
			
			if(main == -1) {
				minus++;
			} else if(main == 0) {
				zero++;
			} else if(main == 1){
				one++;
			}
			
		} else {
			count(x, y, N/3);
			count(x, y+N/3, N/3);
			count(x, y+2*(N/3), N/3);
			count(x+N/3, y, N/3);
			count(x+N/3, y+N/3, N/3);
			count(x+N/3, y+2*(N/3), N/3);
			count(x+2*(N/3), y, N/3);
			count(x+2*(N/3), y+N/3, N/3);
			count(x+2*(N/3), y+2*(N/3), N/3);
		}
		
	}
	
}