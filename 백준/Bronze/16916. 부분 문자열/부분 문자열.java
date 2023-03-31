import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static String S;
	static String P;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		S = br.readLine();
		P = br.readLine();
		
		KMP();
		
		sb.append(ans);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static int[] getPi() {
		int[] pi = new int[P.length()];
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) {
				j = pi[j-1];
			}
			if(P.charAt(i)==P.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}
	
	public static void KMP() {
		int [] pi = getPi();
		
		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			while(j>0 && S.charAt(i)!=P.charAt(j)) {
				j=pi[j-1];
			}
			if(S.charAt(i)==P.charAt(j)) {
				if(j==P.length()-1) {
					ans=1;
					break;
				}else {
					j++;
				}
			}
		}
	}
	
	
	
}