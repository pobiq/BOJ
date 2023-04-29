import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			int[] count1 = new int[26];
			int[] count2 = new int[26];
			
			char[] temp1 = s1.toCharArray();
			
			for(int j=0; j<temp1.length; j++) {
				int index = temp1[j] - 'a';
				count1[index]++;
			}
			
			char[] temp2 = s2.toCharArray();
			
			for(int j=0; j<temp2.length; j++) {
				int index = temp2[j] - 'a';
				count2[index]++;
			}
			
			boolean flag = true;
			
			for(int j=0; j<26; j++) {
				if(count1[j] != count2[j]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				sb.append("Possible").append("\n");
			} else {
				sb.append("Impossible").append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}