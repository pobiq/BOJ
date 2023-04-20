import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return x + " " + y;
		}
	}
	
	static int N, M;
	
	static int[][] map;
	static int[][] temp;
	static int result = Integer.MAX_VALUE;
	static List<Node> chicken_list = new ArrayList<>();
	static List<Node> house_list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		temp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 2) {
					chicken_list.add(new Node(i, j));
				} else if(value == 1) {
					house_list.add(new Node(i, j));
				}
				map[i][j] = value;
			}
		}
		
		List<Node> output = new ArrayList<>();
		
		combi(output, 0, M);
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void combi(List<Node> output, int start, int M) {
		if(output.size() == M) {
			int sum = 0;
			for(Node house : house_list) {
				int min = Integer.MAX_VALUE;
				for(Node chicken : output) {
					int dir = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
					min = Math.min(min, dir);
				}
				sum += min;
			}
			
			result = Math.min(result, sum);
			
			return;
		}
		
		for(int i=start; i<chicken_list.size(); i++) {
			output.add(chicken_list.get(i));
			combi(output, i+1, M);
			output.remove(chicken_list.get(i));
		}
		
	}
}