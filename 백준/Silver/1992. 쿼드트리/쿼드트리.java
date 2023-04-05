import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] matrix;
	static int n;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		recursive(0, 0, n);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void recursive(int x, int y, int n) {
		if(isfull(x, y, n)) {
			sb.append(matrix[x][y]);
		} else {
			sb.append("(");
			recursive(x, y, n/2);
			recursive(x, y+n/2, n/2);
			recursive(x+n/2, y, n/2);
			recursive(x+n/2, y+n/2, n/2);
			sb.append(")");
		}
	}

	static boolean isfull(int x, int y, int n) {

		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(matrix[i][j] != matrix[x][y]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
