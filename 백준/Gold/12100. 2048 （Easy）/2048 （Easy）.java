import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int[][] board;
	static int[][] temp;
	static boolean[][] combine;
	
	//                 위  오  아  왼
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		temp = new int[N][N];
		long result = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int tmp=0; tmp< 1<<(2*5); tmp++) {
			int brute = tmp;
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					temp[a][b] = board[a][b];
				}
			}
			
			
			for(int i=0; i<5; i++) {
				combine = new boolean[N][N];
				int dir = brute % 4;
				brute /= 4;
				upd(temp, dir);
			}
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					if(result < temp[a][b]) {
						result = temp[a][b];
					}
				}
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void upd(int[][] temp, int dir) {
		
		
		if(dir == 0 || dir == 3) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int x = i;
					int y = j;
					
					
					for(int count=1; count<N; count++) {
						int xx = x + dx[dir];
						int yy = y + dy[dir];
						
						if(xx < 0 || xx >= N || yy < 0 || yy >= N) break;
						
						// 기존에 숫자가 있을때
						if(temp[xx][yy] != 0) {
							// 숫자가 같다면
							if(temp[xx][yy] == temp[x][y] && !combine[xx][yy] && !combine[x][y]) {
								temp[x][y] = 0;
								temp[xx][yy] *= 2;
								combine[xx][yy] = true;
								combine[x][y] = false;
							}
							// 숫자가 다르면
							else {
								break;
							}
						} 
						// 기존에 숫자가 없을때
						else {
							if(temp[xx][yy] == 0) {
								temp[xx][yy] = temp[x][y];
								temp[x][y] = 0;
								combine[xx][yy] = combine[x][y];
								combine[x][y] = false;
							}
						}
						x += dx[dir];
						y += dy[dir];
					}
				}
			}
		} else {
			for(int i=N-1; i>=0; i--) {
				for(int j=N-1; j>=0; j--) {
					int x = i;
					int y = j;
					
					
					for(int count=1; count<N; count++) {
						int xx = x + dx[dir];
						int yy = y + dy[dir];
						
						if(xx < 0 || xx >= N || yy < 0 || yy >= N) break;
						
						// 기존에 숫자가 있을때
						if(temp[xx][yy] != 0) {
							// 숫자가 같다면
							if(temp[xx][yy] == temp[x][y] && !combine[xx][yy] && !combine[x][y]) {
								temp[x][y] = 0;
								temp[xx][yy] *= 2;
								combine[xx][yy] = true;
								combine[x][y] = false;
							}
							// 숫자가 다르면
							else {
								break;
							}
						} 
						// 기존에 숫자가 없을때
						else {
							if(temp[xx][yy] == 0) {
								temp[xx][yy] = temp[x][y];
								temp[x][y] = 0;
								combine[xx][yy] = combine[x][y];
								combine[x][y] = false;
							}
						}
						x += dx[dir];
						y += dy[dir];
					}
				}
			}
		}
		
		
	}

	
}