import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] notebook;
	static int n,m,k;
	static int result = 0;
	static int[][][] stickers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		notebook = new int[n][m];
		stickers = new int[k][10][10];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			for(int a=0; a<R; a++) {
				st = new StringTokenizer(br.readLine());
				for(int b=0; b<C; b++) {
					stickers[i][a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] sticker = stickers[i];
			int[] temp = new int[2];
			boolean flag = false;
			
			for(int n=0; n<4; n++) {
				
				temp = getPos(sticker, R, C);
				
				if(temp[0] >= 0 && temp[1] >= 0) {
					flag = true;
					break;
				}
				
				sticker = rotate(sticker, R, C);
				int swap = R;
				R = C;
				C = swap;
			}
			
			if(flag) {
				int x = temp[0];
				int y = temp[1];
				int count = 0;
				for(int a=x; a<x + R; a++) {
					for(int b=y; b<y + C; b++) {
						if(sticker[a-x][b-y] == 1) {
							count++;
							notebook[a][b] = sticker[a-x][b-y];
						}
					}
				}
				result += count;
			}
		}
		
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static int[] getPos(int[][] sticker, int R, int C) {
		int[] temp = new int[2];
		temp[0] = -1;
		temp[1] = -1;
		
		Loop1:
		for(int i=0; i<=n-R; i++) {
			for(int j=0; j<=m-C; j++) {
				
				boolean flag = true;
				
				Loop2:
				for(int a=i; a<i+R; a++) {
					for(int b=j; b<j+C; b++) {
						if(notebook[a][b] == 1 && sticker[a-i][b-j] == 1) {
							flag = false;
							break Loop2;
						}
					}
				}
				
				if(flag) {
					temp[0] = i;
					temp[1] = j;
					break Loop1;
				}
				
			}
		}
		
		return temp;
	}
	
	static int[][] rotate(int[][] sticker, int R, int C) {
		
		int[][] answer = new int[10][10];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				answer[j][R-1-i] = sticker[i][j];
			}
		}
		
		return answer;
	}
	
}