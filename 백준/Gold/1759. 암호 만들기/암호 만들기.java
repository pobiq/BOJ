import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		String[] array = br.readLine().split(" ");
		String[] output = new String[L];
		
		Arrays.sort(array);
		
		dfs(array, output, 0, 0, L, C);
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(String[] array, String[] output, int start, int depth, int end, int k) {
		
		if(depth == end) {
			StringBuffer temp = new StringBuffer();
			int vowels = 0;
			int consonants = 0;
			for(String s : output) {
				if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
					vowels++;
				} else {
					consonants++;
				}
				temp.append(s);
			}
			
			if(vowels >=1 && consonants >=2) {
				sb.append(temp.toString()).append("\n");
			}
			
			return;
		}
		
		for(int i=start; i<k; i++) {
			output[depth] = array[i];
			dfs(array, output, i+1, depth+1, end, k);
		}
	}
}