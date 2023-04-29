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
		
		int result = 0;
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[] count = new int[26];
		
		char[] temp1 = s1.toCharArray();
		
		for(int j=0; j<temp1.length; j++) {
			int index = temp1[j] - 'a';
			count[index]++;
		}
		
		char[] temp2 = s2.toCharArray();
		
		for(int j=0; j<temp2.length; j++) {
			int index = temp2[j] - 'a';
			count[index]--;
		}
		
		
		for(int i=0; i<26; i++) {
			result += Math.abs(count[i]);
		}
		
		sb.append(result);
			
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}